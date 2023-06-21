package com.recipeorganizer.dao;

import com.recipeorganizer.model.Photos;

import java.util.List;

public interface PhotosDao {
    List<Photos> findAllByRecipeId(int recipeId);
}
