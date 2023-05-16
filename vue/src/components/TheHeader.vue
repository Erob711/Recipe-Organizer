<template>
        <div class = "nav">
                <router-link :to="{ name: 'home'}"> Home </router-link>
                <router-link :to="{ name: 'recipes'}">My Recipes</router-link>
                <router-link :to="{ name: 'random-recipe-generator'}">Discover Something New</router-link>
                <router-link :to="{ name: 'community'}"> Community </router-link>
                <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </div>
</template>


<script>
</script>

<style scoped>
.nav {
    display: flex;
    background-color: goldenrod;
    overflow: hidden;
    margin-left: 0;
    margin-right: 0;
    justify-content: space-evenly;
    
}


</style>

