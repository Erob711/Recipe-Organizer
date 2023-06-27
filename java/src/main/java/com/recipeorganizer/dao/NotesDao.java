package com.recipeorganizer.dao;

import com.recipeorganizer.model.Notes;
import com.recipeorganizer.model.Photos;

import java.util.List;

public interface NotesDao {

    List<Notes> findAllByRecipeId(int recipeId);

    Notes getNotesById(int noteId);

    Notes updateNotes(Notes note);
}
