<template>
  <div id="app">
      <!-- <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp; -->
      <the-header class = "the-header"></the-header>
      <router-view/>
      <!-- <div class = "nav">
                <router-link :to="{ name: 'recipes'}">My Recipes</router-link>
                <router-link :to="{ name: 'random-recipe-generator'}">Discover Something New</router-link>
                <router-link :to="{ name: 'community'}"> Community </router-link>
                <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </div> -->
    <the-footer class = "the-footer"></the-footer>
  </div>
</template>

<script>
import TheHeader from "/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/TheHeader.vue"
import TheFooter from "/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/TheFooter.vue"
export default {
  components: {
    TheHeader,
    TheFooter
    //comment
    //added with MacVim
  }
}
</script>

<style >
#app {
  font-family: Avenir, Arial, Helvetica, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 0%;
  margin-bottom: 0%;
}
#nav {
  display: flex;
  justify-content: center;
  align-items: center;
  height: max-content;
}
.the-header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 10px;
  align-items: center;
  justify-content: center;
  height: 2.5rem;
}
.the-footer {
  position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  align-items: center;
  height: 2.5rem;
}

</style>
