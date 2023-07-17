<template>
    <div>
        <!-- TODO: make Create new Recipe form  -->
        <h2>Create New Recipe</h2>
        <form class ="recipe-form">
            <label for="title">Title:<input type = "text" v-model="recipe.title"/></label>
            <label for="ingredient">Ingredients:<input type = "text" v-model="ingredient.ingredient"></label>
            <label for="instructions">Instructions:<input type = "text"></label>
            <label for="photo-url">Photo Url:<input type = "text"></label>
            <label for="notes">Notes:<input type = "text"></label>
            <button type="button" v-on:click="createRecipe">Submit Updated Listing</button>
            <button type="button" v-on:click="createIngredient">Whats da recipe??!</button>
        </form>
    </div>
</template>

<script>
import ingredientService from "/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/services/IngredientsService.js";
import recipeService from "/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/services/RecipeService.js";
export default {
    name: "create-recipe-form",
    data() {
        return {
            activeRecipeId: "",
            recipe: {
                userId: this.$store.state.user.id,
                title: "",
                category: ""
            },
            ingredient: {
                recipeId: "",
                ingredient: "",
                ingredientNumber: 3,
                measurement: ""

            },
            instructions: {

            },
            photos: [],
            notes: {

            }
        }
    },
    methods: {
        createRecipe() {
              recipeService.createRecipe(this.recipe).then((response) => {
                this.ingredient.recipeId = response.data.recipeId;
                this.createIngredient(this.ingredient.recipeId);
                 console.log(response.data);
         }).catch((error) => {
             if (error.response.status == 404) {
                this.$router.push({ name: "home" });
                }
         });
        },
    createIngredient(newRecipeId) {
        ingredientService.createIngredient(newRecipeId, this.ingredient).then((response) => {
                console.log("working");
                console.log(response.data);
             }).catch((error) => {
             if (error.response.status == 404) {
                this.$router.push({ name: "home" });
                }
         });
    }
    },
}
</script>

<style>
form {
    display: flex;
    flex-direction: column;
}
.recipe-form {
    margin-top: 5%;
}
h2 {
    margin-top: 10%;
}
</style>