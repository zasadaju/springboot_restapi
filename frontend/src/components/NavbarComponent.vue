<template>
    <nav>
        <ul>
            <li><router-link to="/">Strona główna</router-link></li>
            <li><router-link to="/users">Lista użytkowników</router-link></li>
            <li><router-link to="/about">O nas</router-link></li>
            <li><router-link to="/login">Zaloguj się</router-link></li>
        </ul>
    </nav>
</template>


<script>
export default {
    name: "NavbarComponent"
};
</script>



            
            