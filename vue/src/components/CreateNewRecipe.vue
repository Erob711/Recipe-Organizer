<template>
    <div>
        <body>
        
        <!-- TODO: make Create new Recipe form  -->
    <h1>Create New Recipe</h1>
    <div class="container">
        <form class ="recipe-form" ref="recipeForm" @submit="createRecipe">
            <input type = "text" class = "item" v-model="recipe.title" placeholder="Title"/>
            <div class = "ingredients" v-for="(input, index) in ingredients" :key="`ingredientInput-${index}`">
                <input type = "text" class = "item" v-model="input.ingredient" placeholder="Ingredient">
                <div class = "add-and-remove-buttons">
                    <a @click.prevent="addIngredient(ingredients)" class="plus-button"><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M256 80c0-17.7-14.3-32-32-32s-32 14.3-32 32V224H48c-17.7 0-32 14.3-32 32s14.3 32 32 32H192V432c0 17.7 14.3 32 32 32s32-14.3 32-32V288H400c17.7 0 32-14.3 32-32s-14.3-32-32-32H256V80z"/></svg></a>
                    <a @click.prevent="removeIngredient(index, ingredients)" class="minus-button"><svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 448 512"><!--! Font Awesome Free 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M432 256c0 17.7-14.3 32-32 32L48 288c-17.7 0-32-14.3-32-32s14.3-32 32-32l352 0c17.7 0 32 14.3 32 32z"/></svg></a>
                </div>
            </div>
            
            <input type = "text" class = "item" placeholder="Instructions" v-model="instructions.instruction">
            <input type = "text" class = "item" placeholder="Photo URL" v-model="photo.photoUrl">
            <input type = "text" class = "item" placeholder="Additional Notes" v-model="note.note">
            <button type="button" class="submit-button" v-on:click="createRecipe">Submit New Recipe</button>

            <!-- TEST -->
            <!-- TEST -->
        </form>
    </div>
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

.container {
    display: flex;
    justify-content: center;
}
.recipe-form {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    
}
.item {
    flex: 1 1 0px;
    width: 10;
    margin-bottom: 15px;
}
h1 {
    margin-right: 22px;
    padding-top: 10%;
    height: 80%;
}
.ingredients {
    display: flex;
}
/* .ingredient {
    flex: 1;
    border: 2px solid yellow;
} */
.ingredients:first-child {
    margin-right: 20px;
}

.submit-button {
    margin-left: 6%;
}
.add-and-remove-buttons {
    display: flex;
    flex-direction: column;
}
a:hover {
    cursor: pointer;
}
.plus-button {
    width: 5px;
    height: 5px;
    margin-bottom: 5px;
}
.minus-button {
    width: 5px;
    height: 5px;
}
.submit-button {
   background-color:#DD7F27;
   border-radius: 10px;
   border: none;
   color: white;
}
</style>