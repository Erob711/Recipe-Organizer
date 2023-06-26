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

        while (result.next()) {
            Ingredients ingredient = mapRowToIngredients(result);
            ingredients.add(ingredient);
        }
        return ingredients;
    }

    @Override
    public Ingredients getIngredientsById(int ingredientId) {
        Ingredients ingredient = new Ingredients();
        String sql = "SELECT *\n" +
               "\tFROM public.ingredients\n" +
                "\tWHERE ingredient_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, ingredientId);
        if (result.next()) {
              ingredient = mapRowToIngredients(result);
          }
        return ingredient;
    }

    @Override
    public Ingredients updateIngredient(Ingredients ingredient) {
            //TO DO Populate updated recipe from MapToRecipe method (get info from DB)
            String sql = "UPDATE ingredients " +
                    "SET ingredient = ?, measurement = ? " +
                    "WHERE ingredient_id = ?;";
            jdbcTemplate.update(sql, ingredient.getIngredient(), ingredient.getMeasurement(), ingredient.getIngredientId());
            return ingredient;
    }

    private Ingredients mapRowToIngredients(SqlRowSet rs) {
        Ingredients ingredients = new Ingredients();
        ingredients.setIngredientId(rs.getInt("ingredient_id"));
        ingredients.setRecipeId(rs.getInt("recipe_id"));
        ingredients.setIngredient(rs.getString("ingredient"));
        //ingredient number will havee to be defined by the java program for now. Need to serialize based off each recipeID
        //we only want to base that serializing off of the ingredients per recipe
        //so example: there could be multipe ingredients of number "2", so long as they map to different recipeIds
        //will be separate from ingredientId, which will serialize ALL ingredients regardless of recipe starting from 1
        ingredients.setIngredientNumber(rs.getInt("ingredient_number"));
        ingredients.setMeasurement(rs.getString("measurement"));
        return ingredients;
    }
}
