package com.recipeorganizer.controller;


import com.recipeorganizer.dao.NotesDao;
import com.recipeorganizer.dao.PhotosDao;
import com.recipeorganizer.model.Notes;
import com.recipeorganizer.model.Photos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//maps to the notes of each individual recipe by recipeId
@RequestMapping(path = "/recipes/{recipeId}/notes")
@CrossOrigin
public class NotesController {
    private final NotesDao notesDao;

    public NotesController(NotesDao notesDao) {
        this.notesDao = notesDao;
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/all", method = RequestMethod.GET)
    public List<Notes> findAllByRecipeId(@PathVariable("recipeId") int recipeId) {
        List<Notes> notes = notesDao.findAllByRecipeId(recipeId);
        return notes;
    }

}
