package com.recipeorganizer.dao;

import com.recipeorganizer.model.Ingredients;
import com.recipeorganizer.model.Recipe;

import java.util.List;

public interface IngredientsDao {
    List<Ingredients> findAllByRecipeId(int recipeId);
}
