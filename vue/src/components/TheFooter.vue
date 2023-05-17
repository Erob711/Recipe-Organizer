<template>
    <div class = "footer">
        <router-link class = "footer-option" :to="{ name: 'home'}">Instagram</router-link>
        <router-link class = "footer-option" :to="{ name: 'home'}">Contact Us</router-link>
        <router-link class = "footer-option" :to="{ name: 'home'}">Write a Review</router-link>
        
    </div>
</template>

<script>
</script>

<style>
.footer {
    display: flex;
    background-color: #000000;
    overflow: hidden;
    margin-right: 0;
    justify-content: space-between;
    
}

.footer-option{
    color: white;
    text-decoration: none;
}
</style>