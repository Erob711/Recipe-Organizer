package com.recipeorganizer.dao;

import com.recipeorganizer.model.Ingredients;
import com.recipeorganizer.model.Instructions;
import com.recipeorganizer.model.Notes;
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
    public List<Photos> findAllByRecipeId(int recipeId) {
        List<Photos> photos = new ArrayList<>();
        String sql = "SELECT *\n" +
                "\tFROM public.photos\n" +
                "\tWHERE recipe_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, recipeId);

        while (result.next()) {
            Photos photo = mapRowToPhotos(result);
            photos.add(photo);
        }
        return photos;
    }

    @Override
    public Photos getPhotoById(int photoId) {
        Photos photo = new Photos();
        String sql = "SELECT *\n" +
                "\tFROM public.photos\n" +
                "\tWHERE photo_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, photoId);
        if (result.next()) {
            photo = mapRowToPhotos(result);
        }
        return photo;
    }

    @Override
    public Photos updatePhotos(Photos photo) {
        String sql = "UPDATE photos " +
                "SET photo_url = ? " +
                "WHERE photo_id = ?;";
        jdbcTemplate.update(sql, photo.getPhotoUrl(), photo.getPhotoId());
        return photo;
    }

    @Override
    public Photos createPhoto(Photos newPhoto) {
        String sql = "INSERT INTO photos (recipe_id, photo_url) " +
                "VALUES (?, ?) RETURNING photo_id; ";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                newPhoto.getRecipeId(), newPhoto.getPhotoUrl());
        return getPhotoById(newId);
    }


    private Photos mapRowToPhotos(SqlRowSet rs) {
        Photos photos = new Photos();
        photos.setPhotoId(rs.getInt("photo_id"));
        photos.setRecipeId(rs.getInt("recipe_id"));
        photos.setPhotoUrl(rs.getString("photo_url"));
        return photos;
    }
}
