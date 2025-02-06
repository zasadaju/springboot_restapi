<template>
    <div>
        <!-- Lista użytkowników -->
        <ul v-for="user in users" :key="user.id">
            <li>{{ user.name }} - {{ user.email }}</li>
            <button @click="deleteUser(user.id)">Usuń</button>
            <button @click="editUser(user)">Edytuj</button>
        </ul>
        <!-- Formularz dodawania nowego użytkownika -->
         <input v-model="newUser.name" placeholder="Imię">
         <input v-model="newUser.email" placeholder="Email">
         <button @click="addUser()">Dodaj użytkownika</button>

    </div>
</template>

<script>
import axios from 'axios';
export default {
    data() {
        return {
            users: [],
            newUser: {name: '', email: ''}
        };
    },
    mounted() {
    this.fetchUsers();
},
methods: {
    fetchUsers() {
        axios.get('http://20.121.42.213:8080/api/users')
        .then(response => {
            this.users = response.data;
        });
    },
    addUser() {
        axios.post('http://20.121.42.213:8080/api/users', this.newUser)
        .then(() => {
            this.users.push(this.newUser);
            this.newUser = {name: '', email: ''};
            this.fetchUsers();
        });
    },
    deleteUser(id) {
        axios.detele('http://20.121.42.213:8080/api/users/${id}')
        .then(() => {
            this.users = this.users.filter(user => user.id !== id)
    });

    },
    editUser(user) {
        this.newUser = { ...user }
    }
    }
};

</script>