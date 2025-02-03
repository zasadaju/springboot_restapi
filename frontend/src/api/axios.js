import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://135.224.16.69:8080/api",
  httpsAgent: false,
  headers: { "Content-Type": "application/json" },
  withCredentials: false // WYMAGANE dla Spring Security
});

// export function login(username, password) {
//   return apiClient.post("/auth/login", new URLSearchParams({ username, password }), {
//     headers: { "Content-Type": "application/x-www-form-urlencoded" }
//   });
// }

export function getUsers() {
  return apiClient.get("/users");
}

export default apiClient;
