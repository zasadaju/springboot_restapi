import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://135.224.16.69:8080/api", // Adres backendu
  headers: { "Content-Type": "application/json" },
  withCredentials: true // WYMAGANE dla Spring Security
});

export function login(username, password) {
  return apiClient.get("/users", {
    auth: { username, password }
  });
}

export default apiClient;
