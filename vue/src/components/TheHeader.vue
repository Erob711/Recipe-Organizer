<template>
        <div class = "nav">
                <router-link class = "header-option" :to="{ name: ''}">What's New</router-link>
                <router-link class = "header-option" :to="{ name: ''}"> Community </router-link>
                <router-link class = "header-option" v-bind:to="{ name: 'l' }" v-if="$store.state.token != ''">Blog</router-link>
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
    height: 5%;
    
}
.header-option{
    color: white;
    text-decoration: none;
}


</style>

