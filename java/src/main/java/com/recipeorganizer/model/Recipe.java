package com.recipeorganizer.model;

public class Recipe {
    private int recipeId;
    private int userId;
    private String title;
    private String category;

    public Recipe() {

    }

    public Recipe(int recipeId, int userId, String title, String category) {
        this.recipeId = recipeId;
        this.userId = userId;
        this.title = title;
        this.category = category;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
