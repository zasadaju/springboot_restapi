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
  import { useRouter } from "vue-router";
  import { login } from "@/api/axios.js";
  
  export default {
    setup() {
      const username = ref("");
      const password = ref("");
      const errorMessage = ref("");
      const router = useRouter();
  
      const loginUser = async () => {
        try {
          await login(username.value, password.value);
          localStorage.setItem("isAuthenticated", "true");
          router.push("/users");
        } catch (error) {
          errorMessage.value = "Błąd logowania!";
          console.error("Błąd logowania:", error);
        }
      };
  
      return { username, password, login: loginUser, errorMessage };
    }
  };
  </script>
  
  <style scoped>
  .error {
    color: red;
  }
  </style>
  