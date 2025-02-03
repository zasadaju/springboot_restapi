import { createRouter, createWebHistory } from 'vue-router';
import HomeView from './views/HomeView.vue';
import UsersView from './views/UsersView.vue';
import AboutView from './views/AboutView.vue';
import UserDetails from './views/UserDetails.vue';
import LoginView from "@/views/LoginView.vue";




//Definicja tras
const routes = [
    { path:'/', component: HomeView },
    { path:'/users', component: UsersView },
    { path: '/users/:id', component: UserDetails },
    { path:'/about', component: AboutView },
    { path: "/login", component: LoginView }
];

//Tworzenie routera
const router = createRouter({
    history: createWebHistory(), 
    routes
});

export default router;