<template>
    <div>
        <!-- TODO: make Create new Recipe form  -->
        <h2>Create New Recipe</h2>
        <form class ="recipe-form">
            <label for="title">Title:<input type = "text" v-model="recipe.title"/></label>
            <div class = "ingredients" v-for="(input, index) in ingredients" :key="`ingredientInput-${index}`">
                <label for="ingredient">Ingredients:<input type = "text" v-model="input.ingredient"></label>
                <div class = "add-and-remove-buttons">
                    <button type="button" v-on:click="addIngredient(ingredients)">Add Ingredient</button>
                    <button type="button" v-on:click="removeIngredient(index, ingredients)">Remove Ingredient</button>
                </div>
            </div>
            
            <label for="instructions">Instructions:<input type = "text" v-model="instructions.instruction"></label>
            <label for="photo-url">Photo Url:<input type = "text" v-model="photo.photoUrl"></label>
            <label for="notes">Notes:<input type = "text" v-model="note.note"></label>
            <button type="button" v-on:click="createRecipe">Submit New Recipe</button>
        </form>
    </div>
</template>

<script>
import ingredientService from "/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/services/IngredientsService.js";
import recipeService from "/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/services/RecipeService.js";
import instructionsService from "/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/services/InstructionsService.js";
import photoService from "/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/services/PhotosService.js";
import notesService from "/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/services/NotesService.js";
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
            ingredients: [{
                recipeId: "",
                ingredient: "",
                ingredientNumber: 3,
                measurement: ""

            },
            {},
            {}],
            instructions: {
                recipeId: "",
                instruction: "",
                instructionNumber: 3
            },
            photo: {
                recipeId: "",
                photoUrl: ""
            },
            note: {
                recipeId: "",
                note: ""
            }
        }
    },
    methods: {
        createRecipe() {
              recipeService.createRecipe(this.recipe).then((response) => {
                let newRecipeId = response.data.recipeId;
                //create ingredient
                this.ingredient.recipeId = newRecipeId;
                this.createIngredient(this.ingredient.recipeId);

                //create instructions
                this.instructions.recipeId = newRecipeId;
                this.createInstructions(this.instructions.recipeId);
                //create photos
                this.photo.recipeId = newRecipeId;
                this.createPhoto(this.photo.recipeId);

                //create notes
                this.note.recipeId = newRecipeId;
                this.createNote(this.note.recipeId);

                 console.log(response.data);
         }).catch((error) => {
             if (error) {
                console.log("issue happened");
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
    },
    createInstructions(newRecipeId) {
        instructionsService.createInstructions(newRecipeId, this.instructions).then((response) => {
                console.log("working");
                console.log(response.data);
             }).catch((error) => {
             if (error.response.status == 404) {
                this.$router.push({ name: "home" });
                }
         });
    },
    createPhoto(newRecipeId) {
        photoService.createPhoto(newRecipeId, this.photo).then((response) => {
                console.log("working");
                console.log(response.data);
             }).catch((error) => {
             if (error) {
                console.log("issue with photo");
                }
         });
    },
    createNote(newRecipeId) {
        notesService.createNote(newRecipeId, this.note).then((response) => {
                console.log("working");
                console.log(response.data);
             }).catch((error) => {
             if (error) {
                console.log("issue with note");
                }
         });
    },
    addIngredient(ingredients) {
        ingredients.push({});
    },
    removeIngredient(index, ingredients){
        ingredients.splice(index, 1);
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