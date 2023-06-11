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
  width: 1000px;
  height: 100vh;
}

.home {
  display: grid;
  grid-template-columns: 0px 1fr 2fr;
  height: 100vh;
}
</style>