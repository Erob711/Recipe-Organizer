package com.recipeorganizer.controller;


import com.recipeorganizer.dao.RecipeDAO;
import com.recipeorganizer.model.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/recipes")
@CrossOrigin
public class RecipeController {
    private final RecipeDAO recipeDAO;

    public RecipeController(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="{userId}/all", method = RequestMethod.GET)
    public List<Recipe> findAllByUserId(@PathVariable("userId") int userId) {
        List<Recipe> recipes = recipeDAO.findAllByUserId(userId);
        return recipes;
    }
}
