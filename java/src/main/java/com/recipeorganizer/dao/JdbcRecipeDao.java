package com.recipeorganizer.dao;

import com.recipeorganizer.model.Recipe;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRecipeDao implements RecipeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRecipeDao(JdbcTemplate jdbcTemplate) {
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
        Recipe recipe = new Recipe();
        String sql = "SELECT *\n" +
                "\tFROM public.recipes\n" +
                "\tWHERE recipe_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, recipeId);
        if (result.next()) {
            recipe = mapRowToRecipe(result);
        }
        return recipe;
    }

    @Override
    public Recipe findByRecipeName(String recipeName) {
        return null;
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        String sql = "INSERT INTO recipes (user_id, title, category) " +
                "VALUES (?, ?, ?) RETURNING recipe_id; ";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                recipe.getUserId(), recipe.getTitle(), recipe.getCategory());
        return findById(newId);
    }

    private Recipe findById(Integer newId) {
        String sql = "SELECT * \n" +
                "FROM recipes\n" +
                "WHERE recipes.recipe_id = ?;\n";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, newId);
        if (results.next()) {
            return mapRowToRecipe(results);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRecipe(int recipeId) {

    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        //TO DO Populate updated recipe from MapToRecipe method (get info from DB)
        String sql = "UPDATE recipes " +
                "SET title = ?, category = ? " +
                "WHERE recipe_id = ?;";
        jdbcTemplate.update(sql, recipe.getTitle(), recipe.getCategory(), recipe.getRecipeId());
        return recipe;
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
