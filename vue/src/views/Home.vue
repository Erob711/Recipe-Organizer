<template>
  <div class="home">
    <hamburger-menu></hamburger-menu>
    <view-recipes class ="recipes"></view-recipes>
  </div>
</template>

<script>

import ViewRecipes from '/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/ViewRecipes.vue'
import HamburgerMenu from '/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/HamburgerMenu.vue'
export default {
  name: "home-view",
  components: {
    ViewRecipes,
    HamburgerMenu
  }
};
</script>

<style>
.recipes {
  display: flex;
  flex-direction: column;
  margin-top: 0%;
}

</style>