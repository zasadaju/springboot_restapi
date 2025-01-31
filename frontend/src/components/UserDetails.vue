<template>
    <div>
      <h1>Szczegóły użytkownika</h1>
      <p v-if="user">👤 {{ user.name }} - 📧 {{ user.email }}</p>
      <p v-else>Ładowanie danych...</p>
    </div>
  </template>
  
  <script>
  import { useRoute } from 'vue-router';
  import { ref, onMounted } from 'vue';
  import apiClient from '@/api/axios.js';
  
  export default {
    setup() {
      const route = useRoute();
      const user = ref(null);
  
      onMounted(() => {
        apiClient.get(`/users/${route.params.id}`)
          .then(response => {
            user.value = response.data;
          })
          .catch(error => {
            console.error('Błąd pobierania użytkownika:', error);
          });
      });
  
      return { user };
    }
  };
  </script>
  