<template>
    <div>
      <h2>Logowanie</h2>
      <form @submit.prevent="login">
        <input v-model="username" placeholder="Nazwa użytkownika" required />
        <input v-model="password" type="password" placeholder="Hasło" required />
        <button type="submit">Zaloguj</button>
      </form>
      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
    </div>
  </template>
  
  <script>
  import { ref } from "vue";
  import apiClient from "@/api/axios.js";
  import { useRouter } from "vue-router";
  
  export default {
    setup() {
      const username = ref("");
      const password = ref("");
      const errorMessage = ref("");
      const router = useRouter();
  
      const login = async () => {
        try {
          await apiClient.post(
            "/login",
            new URLSearchParams({ username: username.value, password: password.value }),
            { headers: { "Content-Type": "application/x-www-form-urlencoded" } }
          );
          router.push("/users"); // Przekierowanie na listę użytkowników po zalogowaniu
        } catch (error) {
          errorMessage.value = "Błąd logowania. Sprawdź dane!";
          console.error("Błąd logowania:", error);
        }
      };
  
      return { username, password, login, errorMessage };
    }
  };
  </script>
  
  <style scoped>
  .error {
    color: red;
  }
  </style>
  