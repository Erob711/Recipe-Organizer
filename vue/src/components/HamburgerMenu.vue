<template>
    <div class="container">

        <input type="checkbox" name="" id="" class="check" v-on:click="setLinks()">
        <ul class="menu-items" v-if="showLinks === true">
            <li><router-link class="header-option" :to="{ name: 'home' }">Recipes</router-link></li>
            <li><router-link class="header-option" :to="{ name: 'community' }"> Discover </router-link></li>
            <li><router-link class="header-option" v-bind:to="{ name: 'logout' }"
                    v-if="$store.state.token != ''">Logout</router-link></li>

        </ul>
        <div class="ham-menu">
            <span class="line line1"></span>
            <span class="line line2"></span>
            <span class="line line3"></span>
        </div>
    </div>
</template>

<script>

export default {
    name: "hamburger-menu",
    data() {
        return {
            showLinks: false

        };
    },
    methods: {
        setLinks() {
            if (this.showLinks === false) {
                this.showLinks = true;
            } else {
                this.showLinks = false;
            }
        }
    }


}
</script>

<style scoped>
*,
*::after,
*::before {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}


.container {
    position: fixed;
    margin: 1rem;
    padding: 1rem;
    height: 2%;
    text-align: center;
    width: 20px;
    margin-left: 0px;
    z-index: 10;
}

.container h1 {
    margin-bottom: 2rem;
}

.menu-items {
    text-align: center;
    position: absolute;
    padding: 2rem;
    margin-top: -6rem;
    margin-left: -1rem;
    top: 10rem;
    left: 3.5rem;
    list-style: none;
    z-index: 10;
    opacity: 0;
    font-size: 2rem;
    border: 2px solid black;
    background-color: black;
    border-radius: 0.25em;
    transform: translateX(-10%);
    transition: transform 100ms ease-in-out, opacity 200ms;
}

.menu-items li {
    color: white;
    padding: 0.5rem;
}

.menu-items li a {
    color: white;
    text-decoration: none;
}

.menu-items li a:hover {
    color: rgb(174, 174, 174);
}

.check {
    position: fixed;
    top: 1.7rem;
    left: .7rem;
    height: 2.8rem;
    width: 2.8rem;
    opacity: 0;
    z-index: 9;
}

.check:hover {
    cursor: pointer;
}

.check:checked~.menu-items {
    display: block;
    transform: translateX(0%);
    opacity: 1;
}

.ham-menu {
    height: 3rem;
    width: 3rem;
    position: absolute;
    top: 0rem;
    left: 0rem;
    padding: 0.5rem;
    z-index: 8;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    background-color: black;
    border-radius: 0.25em;
}

.ham-menu .line {
    background-color: white;
    border-radius: 1em;
    width: 2rem;
    height: 0.25rem;
}

.ham-menu .line1 {
    transform-origin: 0% 0%;
    transition: transform 100ms ease-in-out;
}

.ham-menu .line3 {
    transform-origin: 0% 100%;
    transition: transform 100ms ease-in-out;
}

.check:checked~.ham-menu .line1 {
    display: block;
    transform: rotate(45deg);
}

.check:checked~.ham-menu .line2 {
    opacity: 0;
}

.check:checked~.ham-menu .line3 {
    display: block;
    transform: rotate(-45deg);
}
</style>