package com.recipeorganizer.dao;

import com.recipeorganizer.model.Recipe;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcRecipeDAO implements RecipeDAO{

    @Override
    public List<Recipe> findAllByUserId(int userId) {
        return null;
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
        return null;
    }
}
