import axios from 'axios';

export default {
    
    findAllByRecipeId(recipeId) {
        return axios.get(`/recipes/${recipeId}/photos/all`);
      },
    createIngredient(recipeId, photo) {
        return axios.post(`/recipes/${recipeId}/photos/create`, photo);
    }
}