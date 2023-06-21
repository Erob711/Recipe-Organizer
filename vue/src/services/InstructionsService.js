import axios from 'axios';

export default {


    findAllByRecipeId(recipeId) {
        return axios.get(`/recipes/${recipeId}/instructions/all`);
      }
}