<template>
  <div class="home">
    <hamburger-menu></hamburger-menu>
    <recipe-filters class = "filters"></recipe-filters>
    <view-recipes class ="recipes"></view-recipes>
  </div>
</template>

<script>

import ViewRecipes from '/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/ViewRecipes.vue'
import HamburgerMenu from '/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/HamburgerMenu.vue'
import RecipeFilters from '/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/RecipeFilters.vue'
export default {
  name: "home-view",
  components: {
    ViewRecipes,
    HamburgerMenu,
    RecipeFilters
  }
};
</script>

<style>
.recipes {
  width: 100%;
  height: 100%;
}
.filters {
  height: 100vh;
}

.home {
  display: grid;
  grid-template-columns: 0px 2fr 2fr;
}
</style>