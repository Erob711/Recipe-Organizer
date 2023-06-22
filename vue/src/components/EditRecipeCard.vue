<template>
    <div class="container">
        <p>{{ this.recipeId }}</p>
        {{ this.recipe.title }}
        {{ this.recipe.category }}
        Edit Card Component
        <div>
            <form @submit.prevent="updateRecipe">
                <h1>Update Recipe </h1>
                <div class="form-input-group">
                    <input type="text" placeholder="Title" v-model="recipe.title" required />
                </div>
                <div class="form-input-group">
                    <label for="categories">Category:</label>
                    <select id="categories" v-model = "recipe.category" name="categories">
                        <option value="Breakfast">Breakfast</option>
                        <option value="Lunch">Lunch</option>
                        <option value="Dinner">Dinner</option>
                        <option value="Healthy">Healthy</option>
                        <option value="Simple">Simple</option>
                        <option value="Cost Effective">Cost Effective</option>
                    </select>
                </div>
                <button type="submit">Submit Updated Listing</button>
            </form>
        </div>
    </div>
</template>

<script>
import recipeService from "../services/RecipeService.js"
export default ({
    name: "edit-card",
    props: ["recipeId"],
    data() {
        return {
            recipe: {
                recipeId: this.recipeId,
                //this data below needs to come from db
                userId: '',
                title: '',
                category: ''
            }
            //TODO: Need to display these other tables from db
            // ingredients
            // instructions
            // photos
            // notes
        }
    },
    methods: {
        updateRecipe() {
            recipeService.updateRecipe(this.recipe)
                .then((response) => {
                    if (response.status == 200) {
                        this.$router.push({
                            name: "home"
                        });
                    } else {
                        console.log("Errorrrrr!");
                    }
                }).catch((error) => {
                    const response = error.response;
                    this.registrationErrors = true;
                    if (response.status === 400) {
                        this.registrationErrorMsg = "Bad Request: Validation Errors";
                    }
                });
        }
    },
    created() {
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
    }
});

</script>

<style></style>