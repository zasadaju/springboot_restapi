<template>
    <div>
        <h1>Strona główna</h1>
        <p>Aplikacja ćwiczeniowa Spring Boot & Vue.js</p>
        <div v-for="content in contents" :key="content.id">
            <p>{{ content.text }}</p>
            <img :src="content.imageUrl" :alt="content.text">
        </div>
    </div>
</template>

<script>
    import axios from 'axios';
    // export default {
    //     name: "HomeView"
    // };
    
    export default {
        data() {
            return {
                contents: []
            };
        },
        created() {
            this.fetchContents();
        },
        methods: {
            fetchContents() {
                axios.get('http://20.121.42.213:8080/api/users')
                .then(response => {
                    this.contents = response.data;
                })
                .catch(error => {
                    console.error('Błędy w pobranej treści', error);
                });
            }
        }
    }
</script>