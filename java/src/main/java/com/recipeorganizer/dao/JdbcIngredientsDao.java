package com.recipeorganizer.dao;

import com.recipeorganizer.model.Ingredients;
import com.recipeorganizer.model.Recipe;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcIngredientsDao implements IngredientsDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcIngredientsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Ingredients> findAllByRecipeId(int recipId) {
        List<Ingredients> ingredients = new ArrayList<>();
        String sql = "SELECT *\n" +
                "\tFROM public.ingredients\n" +
                "\tWHERE recipe_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, recipId);

//        while (result.next()) {
//            Ingredients ingredient = mapRowToIngredients(result);
//            ingredients.add(ingredient);
//        }
        return ingredients;
    }

//    private Ingredients mapRowToIngredients(SqlRowSet rs) {
//        Ingredients ingredients = new Ingredients();
//        ingredients.setRecipeId(rs.getInt("recipe_id"));
//        ingredients.setUserId(rs.getInt("user_id"));
//        ingredients.setTitle(rs.getString("title"));
//        ingredients.setCategory(rs.getString("category"));
//        return ingredients;
//    }
}
