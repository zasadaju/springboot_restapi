import { createApp } from 'vue'
import App from './App.vue'
import router from './router';
import { BootstrapVue3, IconsPlugin } from 'bootstrap-vue-3'
import 'bootstrap/dist/css/bootstrap.css'

const app = createApp(App);

app.use(BootstrapVue3)
app.use(IconsPlugin)

app.use(router);
app.mount('#app');

