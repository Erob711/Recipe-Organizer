<template>
    <div class="container">

    <div class="recipe-container">
        <div v-for="recipe in recipes" :key="recipe.recipeId" class="recipe-card">
            <p> {{ recipe.title }}</p>
            <p> {{ recipe.category }}</p>
        </div>
    </div>

    </div>
</template>

<script>
    import recipeService from "../services/RecipeService";
    export default {
        name: "view-recipes",

        data() {
            return {

            };
        },
        mounted() {
            this.retrieveRecipes();
        },
        methods: {
            retrieveRecipes() {
                recipeService.findAllByUserId(this.$store.state.user.id).then((response) => {
                    this.$store.commit("SET_RECIPE_INFO", response.data);
                    
                });
            }
        },
        computed: {
            recipes() {
                return this.$store.state.recipes;
            },
            //TODO: filter method//filter by recipe category
        }
    }
</script>

<style>
</style>