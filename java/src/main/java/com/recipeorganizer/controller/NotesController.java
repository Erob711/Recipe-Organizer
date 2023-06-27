package com.recipeorganizer.controller;


import com.recipeorganizer.dao.NotesDao;
import com.recipeorganizer.dao.PhotosDao;
import com.recipeorganizer.model.Instructions;
import com.recipeorganizer.model.Notes;
import com.recipeorganizer.model.Photos;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path="/{noteId}", method = RequestMethod.GET)
    public Notes getNotesById(@PathVariable("noteId") int noteId) {
        Notes note;
        note = notesDao.getNotesById(noteId);
        return note;
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public Notes updateNotes(@RequestBody Notes note) {
        Notes updatedNotes = notesDao.updateNotes(note);
        if (updatedNotes == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist");
        } else {
            return updatedNotes;
        }
    }
}
