<template>
<div>
    <view-card v-bind:recipeId="parseInt($route.params.recipeId)"></view-card>
</div>
</template>

<script>
import ViewCard from '/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/ViewCard.vue';
export default {
  name: "home-view",
  components: {
    ViewCard
  }
};
</script>

<style>
</style>