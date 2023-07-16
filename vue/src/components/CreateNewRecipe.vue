<template>
    <div>
        <!-- TODO: make Create new Recipe form  -->
        <h2>Create New Recipe</h2>
        <form class ="recipe-form">
            <label for="title">Title:<input type = "text" v-model="recipe.title"/></label>
            <label for="ingredient">Ingredients:<input type = "text"></label>
            <label for="instructions">Instructions:<input type = "text"></label>
            <label for="photo-url">Photo Url:<input type = "text"></label>
            <label for="notes">Notes:<input type = "text"></label>
            <button type="submit" v-on:click="createRecipe">Submit Updated Listing</button>
        </form>
    </div>
</template>

<script>
import recipeService from "/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/services/RecipeService.js";
export default {
    name: "create-recipe-form",
    data() {
        return {
            recipe: {
                userId: this.$store.state.user.id,
                title: "",
                category: ""
            },
            ingredients: [

            ],
            instructions: {

            },
            photos: [],
            notes: {

            }
        }
    },
    methods: {
        createRecipe() {
            recipeService.createRecipe(this.recipe);
        }
    }
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