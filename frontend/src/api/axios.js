import axios from 'axios';

const apiClient = axios.create({
    baseURL: '/api/users',
    headers: {
        'Content-Type': 'application/json',
    },
    timeout: 10000,
});

export default apiClient;