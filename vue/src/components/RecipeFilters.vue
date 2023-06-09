<template>
    <div class="btn-container">
        <button @click="selectCategory(null)">All Recipes</button>
        <button @click="selectCategory('Breakfast')">Breakfast</button>
        <button @click="selectCategory('Lunch')">Lunch</button>
        <button @click="selectCategory('Dinner')">Dinner</button>
        <button @click="selectCategory('Healthy')">Healthy</button>
        <button @click="selectCategory('Simple')">Simple</button>
        <button @click="selectCategory('Cost Effective')">Cost Effective</button>
    </div>
</template>

<script>
</script>

<style>
.btn-container {
    position: relative;
    margin: 1rem;
    padding: 1rem;
    height: 2%;
    text-align: center;
    width: 200px;
    height: 100%;
    background-color: aquamarine;
    margin-left: 0px;
    margin-right: 0px;
}
</style>