<template>
    <div class ="container">
        <edit-ingredients-card v-bind:recipeId="parseInt($route.params.recipeId)"></edit-ingredients-card>
    </div>
    </template>
    
    <script>
    import EditIngredientsCard from '/Users/ericroberson/Desktop/workspace/Recipe-Organizer/Recipe-Organizer-App/vue/src/components/EditIngredientsCard.vue';
    
    export default {
      components: {
        EditIngredientsCard
      }
    };
    </script>
    
    <style>
    </style>