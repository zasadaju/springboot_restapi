<template>
  <div v-if="isValidUser" class="user-card">
    <p>{{ user.name }}</p>
    <button @click="deleteUser">Usuń</button>
  </div>
  <p v-else>Nieprawidłowy użytkownik</p>
</template>

<script>
import apiClient from '@/api/axios.js';

export default {
  props: { user: Object },
  computed: {
    isValidUser() {
      return this.user && typeof this.user === 'object' && this.user.id;
    }
  },
  mounted() {
    if (!this.user) {
      console.error("BŁĄD: this.user jest NULL lub UNDEFINED!");
    } else if (typeof this.user !== 'object') {
      console.error("BŁĄD: this.user nie jest obiektem!", this.user);
    } else {
      console.log("User w UserCard.vue:", this.user);
    }
  },
  watch: {
    user(newVal) {
      console.log("Nowe dane użytkownika:", newVal);
    }
  },
  methods: {
    deleteUser() {
      if (!this.isValidUser) {
        console.error("Błąd: ID użytkownika jest undefined!", this.user);
        return;
      }
      apiClient.delete(`/users/${this.user.id}`)
        .then(() => {
          alert('Użytkownik usunięty!');
          this.$emit('userDeleted', this.user.id); 
        })
        .catch(error => {
          console.error('Błąd usuwania użytkownika:', error);
        });
    }
  }
};
</script>

<style scoped>
.user-card {
  border: 1px solid #ccc;
  padding: 10px;
  margin: 10px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
button {
  background-color: red;
  color: white;
  border: none;
  padding: 5px 10px;
  cursor: pointer;
  transition: 0.3s;
}
button:hover {
  background-color: darkred;
}
</style>
