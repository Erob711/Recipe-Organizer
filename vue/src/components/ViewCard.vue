<template>
    <div>
    <p></p>
    I am the view-card component!
    <div class = "view-card">
        <div class = "recipe-card">
        <p>{{ this.recipeId }}</p>
        {{ this.recipe.title }}
        {{ this.recipe.category }}
        </div>
        <!-- <div v-for="recipe in filteredRecipes" :key="recipe.recipeId" class="recipe-card"></div> -->
        <div v-for="ingredient in ingredients" :key="ingredient.ingredientId" class="ingredients-card">
        {{  ingredient.ingredient }}
        </div>
        <div v-for="instruction in instructions" :key="instruction.instructionId" class="instructions-card">
        {{  instruction.instruction }}
        </div>
        <button class = "edit-card"><router-link :to="{ name: 'edit-recipe-page', params: { recipeId: this.recipe.recipeId, recipe: this.recipe }}" >Edit</router-link></button>
    </div>

    </div>
</template>

<script>
import recipeService from "../services/RecipeService.js"
import ingredientsService from "../services/IngredientsService.js"
import instructionsService from "../services/InstructionsService.js"
export default {
    name: 'view-recipe-card',
    props: ["recipeId"],
    data() {
        return {
            recipe: {
                recipeId: this.recipeId,
                //this data below needs to come from db
                userId: '',
                title: '',
                category: ''
            },
            //TODO: Need to display these other tables from db
           
            // instructions
            // photos
            // notes
        }
    },
    methods: {
        retrieveIngredients() {
            ingredientsService.findAllByRecipeId(this.recipeId).then((response) => {
                this.$store.commit("SET_INGREDIENTS", response.data);
            });
        },
        retrieveInstructions() {
            instructionsService.findAllByRecipeId(this.recipeId).then((response) => {
                this.$store.commit("SET_INSTRUCTIONS", response.data);
            });
        }
        
    },
    mounted() {
        this.retrieveIngredients();
        this.retrieveInstructions();
    },
    created() {
        //get recipee
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
    },
    computed: {
        ingredients() {
            return this.$store.state.ingredients;
        },
        instructions() {
            return this.$store.state.instructions;
        }
    }
}
</script>

<style>
.recipe-card {
    border: 1px solid black;
}
.ingredients-card {
    border: 1px solid black;
}
.instructions-card {
    border: 1px solid black;
}
</style>