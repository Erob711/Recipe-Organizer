import axios from 'axios';

export default {

  findAllByUserId(userId) {
    return axios.get(`/recipes/${userId}/all`)
  },
  getRecipeById(recipeId) {
    return axios.get(`/recipes/${recipeId}`);
  }

}
