<template>
    <div class="container">

        <input type="checkbox" name="" id="" class="check">
        <ul class="menu-items">
            <li><a href="https://google.com" target="_blank">Create</a></li>
            <li><a href="https://google.com" target="_blank">Discover</a></li>
            <li><a href="https://google.com" target="_blank">Plan</a></li>
        </ul>
        <div class="ham-menu">
            <span class="line line1"></span>
            <span class="line line2"></span>
            <span class="line line3"></span>
        </div>
    </div>
</template>

<style scoped>
*,
*::after,
*::before {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}


.container {
    position: relative;
    margin: 1rem;
    padding: 1rem;
    height: 2%;
    text-align: center;
    width: 20px;
    margin-left: 0px;
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

.menu-items li{
    color: white;
    padding: 0.5rem;
}

.menu-items li a{
    color: white;
    text-decoration: none;
}

.menu-items li a:hover{
    color: rgb(174, 174, 174);
}

.check {
    position: absolute;
    top: 0rem;
    left: 0rem;
    height: 3rem;
    width: 3rem;
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