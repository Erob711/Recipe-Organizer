package com.recipeorganizer.dao;

import com.recipeorganizer.model.Photos;

import java.util.List;

public interface PhotosDao {
    List<Photos> findAllByRecipeId(int recipeId);

    Photos getPhotoById(int photoId);

    Photos updatePhotos(Photos photo);

    Photos createPhoto(Photos newPhoto);
}
