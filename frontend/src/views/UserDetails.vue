<template>
    <div>
      <h1>Szczegóły użytkownika</h1>
      <p>ID: {{ userId }}</p>
    </div>
  </template>
  
  <script>
  import { useRoute } from 'vue-router';
  
  export default {
    setup() {
      const route = useRoute();
      return { userId: route.params.id };
    }
  };
  </script>
  