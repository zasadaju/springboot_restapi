import { createRouter, createWebHistory } from 'vue-router';
import Home from './views/Home.vue';
import Users from './views/Users.vue';
import About from './views/About.vue';
import UserDetails from './views/UserDetails.vue';


//Definicja tras
const routes = [
    { path:'/', component: Home },
    { path:'/users', component: Users },
    { path: 'users/:id', component: UserDetails },
    { path:'/about', component: About },
];

//Tworzenie routera
const router = createRouter({
    history: createWebHistory(), 
    routes
});

export default router;