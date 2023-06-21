package com.recipeorganizer.dao;

import com.recipeorganizer.model.Ingredients;
import com.recipeorganizer.model.Instructions;
import com.recipeorganizer.model.Photos;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPhotosDao implements PhotosDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPhotosDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Photos> findAllByRecipeId(int recipId) {
        List<Photos> photos = new ArrayList<>();
        String sql = "SELECT *\n" +
                "\tFROM public.photos\n" +
                "\tWHERE recipe_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, recipId);

        while (result.next()) {
            Photos photo = mapRowToPhotos(result);
            photos.add(photo);
        }
        return photos;
    }

    private Photos mapRowToPhotos(SqlRowSet rs) {
        Photos photos = new Photos();
        photos.setPhotoId(rs.getInt("photo_id"));
        photos.setRecipeId(rs.getInt("recipe_id"));
        photos.setPhotoUrl(rs.getString("photo_url"));
        return photos;
    }
}
