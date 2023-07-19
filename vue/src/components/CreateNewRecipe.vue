<template>
    <div>
        <body>
        
        <!-- TODO: make Create new Recipe form  -->
        <h2>Create New Recipe</h2>
        <form class ="recipe-form" ref="recipeForm" @submit="createRecipe">
            <label for="title">Title:<input type = "text" v-model="recipe.title"/></label>
            <div class = "ingredients" v-for="(input, index) in ingredients" :key="`ingredientInput-${index}`">
                <label for="ingredient">Ingredients:<input type = "text" v-model="input.ingredient"></label>
                <div class = "add-and-remove-buttons">
                    <!-- <button type="button" v-on:click="addIngredient(ingredients)">Add Ingredient</button> -->
                    <!-- <a @click.prevent="addIngredient(ingredients)"><i class="fas fa-minus-circle"></i></a> -->
                    <a @click.prevent="addIngredient(ingredients)"><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M256 80c0-17.7-14.3-32-32-32s-32 14.3-32 32V224H48c-17.7 0-32 14.3-32 32s14.3 32 32 32H192V432c0 17.7 14.3 32 32 32s32-14.3 32-32V288H400c17.7 0 32-14.3 32-32s-14.3-32-32-32H256V80z"/></svg></a>
                    <a @click.prevent="removeIngredient(index, ingredients)"><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M432 256c0 17.7-14.3 32-32 32L48 288c-17.7 0-32-14.3-32-32s14.3-32 32-32l352 0c17.7 0 32 14.3 32 32z"/></svg></a>
                    <!-- <button type="button" v-on:click="removeIngredient(index, ingredients)">Remove Ingredient</button> -->
                </div>
            </div>
            
            <label for="instructions">Instructions:<input type = "text" v-model="instructions.instruction"></label>
            <label for="photo-url">Photo Url:<input type = "text" v-model="photo.photoUrl"></label>
            <label for="notes">Notes:<input type = "text" v-model="note.note"></label>
            <button type="button" v-on:click="createRecipe">Submit New Recipe</button>

            <!-- TEST -->
            <!-- TEST -->
        </form>
        </body>
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

            }],
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
                //create ingredients
                this.ingredients.forEach((ingredient) => {
                    ingredient.recipeId = newRecipeId;
                    this.createIngredient(ingredient.recipeId, ingredient);
                });
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

                 this.$refs.recipeForm.reset();
         }).catch((error) => {
             if (error) {
                console.log("issue happened");
                }
         });
        },
    createIngredient(newRecipeId, ingredient) {
        ingredientService.createIngredient(newRecipeId, ingredient).then((response) => {
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
        if (ingredients.length > 1) {
        ingredients.splice(index, 1);
        }
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
.fas fa-minus-circle {
    color: black;
}
</style>