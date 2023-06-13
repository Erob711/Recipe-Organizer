<template>
    <div>
    <p></p>
    I am the view-card component!
    <div>
        <p>{{ this.recipeId }}</p>
        <!-- need to get from Database -->
        <!-- {{ this.recipe.title }}
        {{ this.recipe.category }} -->
    </div>
    </div>
</template>

<script>
export default {
    name: 'view-recipe-card',
    props: ["recipeId"],
    data() {
        return {
            //TODO: This recipe data needs to come from the database. Need to use .getRecipeById(recipeId) from RecipeService
            recipe: {
                recipeId: this.recipeId,
                //this data below needs to come from db
                userId: '',
                title: '',
                category: ''
            }
        }
    },
    created() {
        //Needs to call getRecipeById(recipeId)

    }
}
</script>

<style>
</style>