<template>
    <div>
      <h1>Szczegóły użytkownika</h1>
      <p>ID: {{ UserDetails.id }}</p>
      <p>Imię: {{ UserDetails.name }}</p>
      <p>Email: {{ UserDetails.email }}</p>
    </div>
  </template>
  
  <script>
  import UserDetails from '@/components/UserDetails.vue';
import { useRoute } from 'vue-router';
  
  export default {
    setup() {
      const route = useRoute();
      return { userId: route.params.id };
    }
  };
  </script>
  