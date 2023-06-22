<template>
<div class ="container">
    <edit-recipe-card v-bind:recipeId="parseInt($route.params.recipeId)"></edit-recipe-card>
</div>
</template>

<script>
import EditRecipeCard from '/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/EditRecipeCard.vue';

export default {
  components: {
    EditRecipeCard
  }
};
</script>

<style>
</style>