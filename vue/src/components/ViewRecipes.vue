<template>
    <div class="container">
        <!-- <div class = "filter-container">
        <p>Breakfast</p>
        <p>Lunch</p>
        <p>Dinner</p>
        <p>Healthy</p>
        <p>Simple</p>
        <p>Cost-Effective</p>
    
        
    </div> -->
        <div class="recipe-container">
            <div v-for="recipe in filteredRecipes" :key="recipe.recipeId" class="recipe-card">
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
            selectedCategory: null

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
        selectCategory(category) {
            this.selectedCategory = category;
        },
    },
    computed: {
        filteredRecipes() {
            if (!this.selectedCategory) {
                return this.$store.state.recipes;
            }
            return this.$store.state.recipes.filter((recipe) => recipe.category === this.selectedCategory);
        },

    }
}
</script>

<style scoped>
.container {
    position: relative;
    top: 0px;
    left: 0px;
}

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

.filter-container {
    display: flex;
    background-color: white;
    overflow: hidden;
    margin-left: 0;
    margin-right: 0;
    justify-content: space-evenly;
    height: 100%;
    width: 200px;
    background-color: #3498db;
    position: relative;
    left: 0px;
    top: 0px;

}

.recipe-container {
    display: flex;
    background-color: whitesmoke;
    overflow: hidden;
    margin-left: 0;
    margin-right: 0;
    justify-content: space-evenly;
    height: 20%;
    width: 70%;
    position: relative;
    left: 0%;
    top: 100px;

}

</style>