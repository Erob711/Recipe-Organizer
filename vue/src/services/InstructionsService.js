import axios from 'axios';

export default {

    findAllByRecipeId(recipeId) {
        return axios.get(`/recipes/${recipeId}/instructions/all`);
      },
      createInstructions(recipeId, instructions) {
        return axios.post(`/recipes/${recipeId}/instructions/create`, instructions);
    }
}