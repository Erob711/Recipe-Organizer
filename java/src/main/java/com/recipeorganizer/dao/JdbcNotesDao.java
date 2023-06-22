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

    private Notes mapRowToNotes(SqlRowSet rs) {
        Notes note = new Notes();
        note.setNoteId(rs.getInt("note_id"));
        note.setRecipeId(rs.getInt("recipe_id"));
        note.setNote(rs.getString("note"));
        return note;
    }
}
