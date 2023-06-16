package com.recipeorganizer.dao;

import com.recipeorganizer.model.Recipe;

import java.util.List;

public interface RecipeDao {
    List<Recipe> findAllByUserId(int userId);

    Recipe getRecipeById(int recipeId);

    Recipe findByRecipeName(String recipeName);

    void createRecipe(Recipe recipe);

    void deleteRecipe(int recipeId);

    Recipe updateRecipe(Recipe recipe);

}
