import axios from 'axios';

export default {

    findAllByRecipeId(recipeId) {
        return axios.get(`/recipes/${recipeId}/notes/all`);
      },
     createNote(recipeId, note) {
        return axios.post(`/recipes/${recipeId}/notes/create`, note);
    }
}