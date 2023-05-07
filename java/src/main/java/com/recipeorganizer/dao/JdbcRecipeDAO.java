package com.recipeorganizer.dao;

import com.recipeorganizer.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecipeDAO implements RecipeDAO{

    private final JdbcTemplate jdbcTemplate;

    public JdbcRecipeDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Recipe> findAllByUserId(int userId) {
        List<Recipe> recipes = new ArrayList<>();
        String sql = "SELECT *\n" +
                "\tFROM public.recipes\n" +
                "\tWHERE user_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, userId);

        while (result.next()) {
            Recipe recipe = mapRowToRecipe(result);
            recipes.add(recipe);
        }
        return recipes;
    }

    @Override
    public Recipe getRecipeById(int recipeId) {
        return null;
    }

    @Override
    public Recipe findByRecipeName(String recipeName) {
        return null;
    }

    @Override
    public void createRecipe(Recipe recipe) {

    }

    @Override
    public void deleteRecipe(int recipeId) {

    }

    @Override
    public void updateRecipe(Recipe recipe) {

    }

    //mapping method
    private Recipe mapRowToRecipe(SqlRowSet rs) {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(rs.getInt("recipe_id"));
        recipe.setUserId(rs.getInt("user_id"));
        recipe.setTitle(rs.getString("title"));
        recipe.setCategory(rs.getString("category"));
        return recipe;
    }
}
