package com.recipeorganizer.controller;


import com.recipeorganizer.dao.InstructionsDao;
import com.recipeorganizer.dao.PhotosDao;
import com.recipeorganizer.model.Instructions;
import com.recipeorganizer.model.Photos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
