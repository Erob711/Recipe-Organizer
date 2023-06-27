package com.recipeorganizer.controller;


import com.recipeorganizer.dao.InstructionsDao;
import com.recipeorganizer.dao.PhotosDao;
import com.recipeorganizer.model.Instructions;
import com.recipeorganizer.model.Notes;
import com.recipeorganizer.model.Photos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
//maps to the photos of each individual recipe by recipeId
@RequestMapping(path = "/recipes/{recipeId}/photos")
@CrossOrigin
public class PhotosController {

    private final PhotosDao photosDao;

    public PhotosController(PhotosDao photosDao) {
        this.photosDao = photosDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/all", method = RequestMethod.GET)
    public List<Photos> findAllByRecipeId(@PathVariable("recipeId") int recipeId) {
        List<Photos> instructions = photosDao.findAllByRecipeId(recipeId);
        return instructions;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/{photoId}", method = RequestMethod.GET)
    public Photos getPhotosById(@PathVariable("photoId") int photoId) {
        Photos photo;
        photo = photosDao.getPhotoById(photoId);
        return photo;
    }


    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public Photos updatePhotos(@RequestBody Photos photo) {
        Photos updatedPhotos = photosDao.updatePhotos(photo);
        if (updatedPhotos == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist");
        } else {
            return updatedPhotos;
        }
    }
}
