package com.recipeorganizer.dao;

import com.recipeorganizer.model.Ingredients;
import com.recipeorganizer.model.Instructions;

import java.util.List;

public interface InstructionsDao {
    List<Instructions> findAllByRecipeId(int recipeId);
}