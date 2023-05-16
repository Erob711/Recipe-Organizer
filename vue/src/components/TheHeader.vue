<template>
        <div class = "nav">
                <router-link class = "header-option" :to="{ name: 'home'}"> Home </router-link>
                <router-link class = "header-option" :to="{ name: 'recipes'}">My Recipes</router-link>
                <router-link class = "header-option" :to="{ name: 'random-recipe-generator'}">Discover Something New</router-link>
                <router-link class = "header-option" :to="{ name: 'community'}"> Community </router-link>
                <router-link class = "header-option" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
        </div>
</template>


<script>
</script>

<style scoped>
.nav {
    display: flex;
    background-color: #E4A193;
    overflow: hidden;
    margin-left: 0;
    margin-right: 0;
    justify-content: space-evenly;
    
}
.header-option{
    color: white;
    text-decoration: none;
}


</style>

