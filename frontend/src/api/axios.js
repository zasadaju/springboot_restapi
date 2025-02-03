import axios from "axios";

const apiClient = axios.create({
  baseURL: "http://135.224.16.69:8080",
  headers: { "Content-Type": "application/json" },
  withCredentials: true 
});

export default apiClient;
