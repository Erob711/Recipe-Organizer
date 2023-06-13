import axios from 'axios';

export default {

  findAllByUserId(userId) {
    return axios.get(`/recipes/${userId}/all`)
  },
  getRecipeById(id) {

    //TODO: create method on backend and test with Postman
    return id;
  }

}
