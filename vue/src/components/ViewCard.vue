<template>
    <div>
    <p></p>
    I am the view-card component!
    <div>
        <p>{{ this.recipeId }}</p>
        {{ this.recipe.title }}
        {{ this.recipe.category }}
    </div>
    </div>
</template>

<script>
import recipeService from "../services/RecipeService.js"
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
        recipeService.getRecipeById(this.recipeId)
        .then((response) => {
            this.$store.commit("SET_ACTIVE_RECIPE", response.data);
            this.recipe = response.data;
        })
        .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push({ name: "NotFound" });
        }
      });
    }
}
</script>

<style>
</style>