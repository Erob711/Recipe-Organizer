import axios from 'axios';

export default {

    findAllByRecipeId(recipeId) {
        return axios.get(`/recipes/${recipeId}/ingredients/all`);
      },

    createIngredient(recipeId, ingredient) {
        return axios.post(`/recipes/${recipeId}/ingredients/create`, ingredient);
    }
}