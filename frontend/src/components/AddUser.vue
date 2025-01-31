<template>
    <div>
      <h2>Dodaj użytkownika</h2>
      <form @submit.prevent="addUser">
        <input v-model="name" placeholder="Imię" required />
        <input v-model="email" type="email" placeholder="Email" required />
        <button type="submit">Dodaj</button>
      </form>
    </div>
  </template>
  
  <script>
  import { ref } from 'vue';
  import apiClient from '@/api/axios.js';
  
  export default {
    setup() {
      const name = ref('');
      const email = ref('');
  
      const addUser = () => {
        apiClient.post('/users', { name: name.value, email: email.value })
          .then(() => {
            alert('Użytkownik dodany!');
            name.value = '';
            email.value = '';
          })
          .catch(error => {
            console.error('Błąd dodawania użytkownika:', error);
          });
      };
  
      return { name, email, addUser };
    }
  };
  </script>
  