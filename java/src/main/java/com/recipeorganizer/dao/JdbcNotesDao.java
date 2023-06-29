package com.recipeorganizer.dao;

import com.recipeorganizer.model.Instructions;
import com.recipeorganizer.model.Notes;
import com.recipeorganizer.model.Photos;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcNotesDao implements NotesDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcNotesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Notes> findAllByRecipeId(int recipeId) {
        List<Notes> notes = new ArrayList<>();
        String sql = "SELECT *\n" +
                "\tFROM public.notes\n" +
                "\tWHERE recipe_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, recipeId);

        while (result.next()) {
            Notes note = mapRowToNotes(result);
            notes.add(note);
        }
        return notes;

    }

    @Override
    public Notes getNotesById(int noteId) {
        Notes note = new Notes();
        String sql = "SELECT *\n" +
                "\tFROM public.notes\n" +
                "\tWHERE note_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, noteId);
        if (result.next()) {
            note = mapRowToNotes(result);
        }
        return note;
    }

    @Override
    public Notes updateNotes(Notes note) {
        String sql = "UPDATE notes " +
                "SET note = ? " +
                "WHERE note_id = ?;";
        jdbcTemplate.update(sql, note.getNote(), note.getNoteId());
        return note;
    }

    @Override
    public Notes createNote(Notes newNote) {
        String sql = "INSERT INTO notes (recipe_id, note) " +
                "VALUES (?, ?) RETURNING note_id; ";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                newNote.getRecipeId(), newNote.getNote());
        return getNotesById(newId);
    }


    private Notes mapRowToNotes(SqlRowSet rs) {
        Notes note = new Notes();
        note.setNoteId(rs.getInt("note_id"));
        note.setRecipeId(rs.getInt("recipe_id"));
        note.setNote(rs.getString("note"));
        return note;
    }
}
