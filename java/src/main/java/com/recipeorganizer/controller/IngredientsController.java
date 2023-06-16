package com.recipeorganizer.controller;

import com.recipeorganizer.dao.IngredientsDao;
import com.recipeorganizer.model.Ingredients;
import com.recipeorganizer.model.Recipe;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//maps to the ingredients of each individual recipe by recipeId
@RequestMapping(path = "/recipes/{recipeId}/ingredients")
@CrossOrigin
public class IngredientsController {

    private final IngredientsDao ingredientsDao;

    public IngredientsController(IngredientsDao ingredientsDao) {
        this.ingredientsDao = ingredientsDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/all", method = RequestMethod.GET)
    public List<Ingredients> findAllByRecipeId(@PathVariable("recipeId") int recipeId) {
        List<Ingredients> ingredients = ingredientsDao.findAllByRecipeId(recipeId);
        return ingredients;
    }




}
