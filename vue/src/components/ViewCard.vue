<template>
    <div>
    <p></p>
    I am the view-card component!
    <div>
        <p>{{ this.recipeId }}</p>
        {{ this.recipe.title }}
        {{ this.recipe.category }}
        <button class = "edit-card"><router-link :to="{ name: 'edit-recipe-page', params: { recipeId: this.recipe.recipeId, recipe: this.recipe }}" >Edit</router-link></button>
    </div>
    <!-- TO DO: Ingredients for each recipe need to display properly -->
    <!-- <div class = "ingredients" v-for="ingredient in this.ingredients" :key="ingredient.ingredientId">
        {{ this.ingredient.ingredientId }}
        {{ this.ingredient.ingredient }}
        {{ this.ingredient.measurement }}
    </div> -->
    </div>
</template>

<script>
import recipeService from "../services/RecipeService.js"
// import ingredientsService from "../services/IngredientsService.js"
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
            // ingredients
            ingredients: [
                {
                    ingredientId: '',
                    recipeId: this.recipeId,
                    ingredient: '',
                    ingredientNumber: '',
                    measurement: ''
                }
            ]
            // instructions
            // photos
            // notes
        }
    },
    methods: {
        // retrieveIngredients() {
        //     ingredientsService.findAllByRecipeId(this.recipeId).then((response) => {
        //         this.$store.commit("SET_INGREDIENTS", response.data);
        //     });
        // }
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
      //get ingredients
    //   ingredientsService.findAllByRecipeId(this.recipeId)
    //   .then((response) => {
    //         this.$store.commit("SET_INGREDIENTS", response.data);
    //         this.ingredients = response.data;
    //     })
    //     .catch((error) => {
    //     if (error.response.status == 404) {
    //       this.$router.push({ name: "NotFound" });
    //     }
    //   });
    }
}
</script>

<style>
</style>