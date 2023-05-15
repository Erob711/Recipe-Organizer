<template>
    <div>
        <div class = "nav">
            <ul class = "header-options">
                <li><router-link :to="{ name: 'recipes'}">My Recipes</router-link></li>
                <li><router-link :to="{ name: 'random-recipe-generator'}">Discover Something New</router-link></li>
                <li><router-link :to="{ name: 'community'}"> Community </router-link></li>
                <li><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></li>
            </ul>
        </div>
    </div>
</template>


<script>
</script>

<style>
.nav {
    background-color: black;
    overflow: hidden;
    justify-content: center;
    margin-left: 0;
    margin-right: 0;
    justify-content: space-between;
}
.ul {
   
}

</style>

