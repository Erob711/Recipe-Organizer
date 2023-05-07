<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <p><router-link :to="{ name: 'recipes'}">My Recipes</router-link></p>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
