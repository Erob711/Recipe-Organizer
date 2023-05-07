<template>
    <div class="recipes">
      <h1>Your Recipes</h1>
      <p>Here are all your Recipes</p>
      <view-recipes />
    </div>
  </template>
  
  <script>
  import viewRecipes from '../components/ViewRecipes.vue';
  export default{
    name: "recipes",
    components: {
        viewRecipes
    }
  };
  </script>