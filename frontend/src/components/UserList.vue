<template>
    <div>
      <h2>Lista użytkowników</h2>
      <div v-if="users.length">
        <UserCard v-for="user in users" :key="user.id" :user="user" />
      </div>
      <p v-else>Ładowanie użytkowników...</p>
    </div>
  </template>
  
  <script>
  import UserCard from './UserCard.vue';
  import apiClient from '@/api/axios.js';
  
  export default {
    components: { UserCard },
    data() {
      return { users: [] };
    },
    mounted() {
      apiClient.get('/users')
        .then(response => {
          this.users = response.data;
        })
        .catch(error => {
          console.error('Błąd pobierania użytkowników:', error);
        });
    }
  };
  </script>
  