import axios from "axios";

const apiClient = axios.create({
  baseURL: "/api", // NIE używamy pełnego adresu IP
  headers: { "Content-Type": "application/json" },
  withCredentials: true, // Wymagane dla Spring Security
});

export function login(username, password) {
  return apiClient.get("/users", {
    auth: { username, password }
  });
}

export default apiClient;
