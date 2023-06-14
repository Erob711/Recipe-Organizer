<template>
<div class ="container">
    <edit-card v-bind:recipeId="parseInt($route.params.recipeId)"></edit-card>
</div>
</template>

<script>
import EditCard from '/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/EditCard.vue';

export default {
  components: {
    EditCard
  }
};
</script>

<style>
</style>