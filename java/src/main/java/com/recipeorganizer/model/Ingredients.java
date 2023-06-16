package com.recipeorganizer.model;

public class Ingredients {

    private int ingredientId;
    private int recipeId;
    private String ingredient;
    private int ingredientNumber;

    private String measurement;

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getIngredientNumber() {
        return ingredientNumber;
    }

    public void setIngredientNumber(int ingredientNumber) {
        this.ingredientNumber = ingredientNumber;
    }
}
