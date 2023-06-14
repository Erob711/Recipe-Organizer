<template>
    <div class="container">
        <div class="btn-container">
        <button class = "filter-btn" @click="selectCategory(null)">All Recipes</button>
        <button class = "filter-btn" @click="selectCategory('Breakfast')">Breakfast</button>
        <button class = "filter-btn" @click="selectCategory('Lunch')">Lunch</button>
        <button class = "filter-btn" @click="selectCategory('Dinner')">Dinner</button>
        <button class = "filter-btn" @click="selectCategory('Healthy')">Healthy</button>
        <button class = "filter-btn" @click="selectCategory('Simple')">Simple</button>
        <button class = "filter-btn" @click="selectCategory('Cost Effective')">Cost Effective</button>
        </div>
    
        <div class="recipe-container">
            <div v-for="recipe in filteredRecipes" :key="recipe.recipeId" class="recipe-card">
                <p> {{ recipe.title }}</p>
                <p> {{ recipe.category }}</p>
                <button class="go-to">
                    <router-link :to="{ name: 'view-card', params: { recipeId: recipe.recipeId}}">Go To</router-link>
                </button>
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
    max-width: 200px;
    backdrop-filter: blur(10px);
    box-shadow: 0px 5px 10px rgba(0, 0, 0, 0.2);
    transition: transform 500ms ease;
    background-color: #e8b4a9;
    z-index: 0;
    font-weight: bold;
    flex-basis: calc(50% - 20px);
    width: calc(50% - 10px);
}

.recipe-container {
    display: flex;
    background-color: whitesmoke;
    overflow: hidden;
    margin-left: 10%;
    margin-right: 0;
    justify-content: space-evenly;
    height: 30%;
    width: 1500px;
    position: relative;
    left: 0%;
    top: 100px;
}
.btn-container {
    top: 1rem;
    display: flex;
    flex-direction: column;
    position: relative;
    text-align: center;
    width: 150px;
    height: 100vh;
    margin-left: -10px;
    margin-right: 0px;
    overflow: hidden;
    justify-content: space-evenly;
}
.container {
    display: grid;
    grid-template-columns: 1fr 2fr;
    left: 0rem;
}
.filter-btn {
    background-color: #DDE8A9;
    z-index: 0;
    top: 0rem;
    left: 0rem;
    height: 30px;
    border-color: #DDE8A9;
    border-bottom: #e8b4a9;
    border-top: #DDE8A9;
    text-align: right;
}
.filter-btn:hover {
    background-color: #e8b4a9;
    transition: 0.6s;
}

.filter-btn:active {
    background-color: #64382F;
}

</style>