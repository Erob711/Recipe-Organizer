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
            },
            
        },
        computed: {
            recipes() {
                return this.$store.state.recipes;
            },
            //TODO: filter method//filter by recipe category
        }
    }
</script>

<style scoped>
.recipe-card {
  position: relative;
  margin: 10px;
  padding: 30px;
  border: 1px solid #ccc;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  align-items: center;
  max-width: 300px;
  backdrop-filter: blur(10px);
  box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
  transition: transform 500ms ease;
  background-color: #e8b4a9;
  z-index: 0;
  font-weight: bold;
  flex-basis: calc(50% - 20px);
  width: calc(50% - 10px);
}
</style>