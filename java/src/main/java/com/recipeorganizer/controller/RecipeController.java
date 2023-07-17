package com.recipeorganizer.controller;


import com.recipeorganizer.dao.RecipeDao;
import com.recipeorganizer.model.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.security.PermitAll;
import java.util.List;

@PermitAll
@RestController
@RequestMapping(path = "/recipes")
@CrossOrigin
public class RecipeController {
    private final RecipeDao recipeDAO;

    public RecipeController(RecipeDao recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="{userId}/all", method = RequestMethod.GET)
    public List<Recipe> findAllByUserId(@PathVariable("userId") int userId) {
        List<Recipe> recipes = recipeDAO.findAllByUserId(userId);
        return recipes;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/{recipeId}", method = RequestMethod.GET)
    public Recipe getRecipeById(@PathVariable("recipeId") int recipeId) {
        Recipe recipe;
        recipe = recipeDAO.getRecipeById(recipeId);
        return recipe;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path ="/create", method = RequestMethod.POST)
    public Recipe createRecipe(@RequestBody Recipe newRecipe) {
        return recipeDAO.createRecipe(newRecipe);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        Recipe updatedRecipe = recipeDAO.updateRecipe(recipe);
        if (updatedRecipe == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist");
        } else {
            return updatedRecipe;
        }
    }
}
