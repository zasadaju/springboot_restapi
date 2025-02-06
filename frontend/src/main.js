import { createApp } from 'vue'
import App from './App.vue'
import router from './router';
import { BootstrapVue3, IconsPlugin } from 'bootstrap-vue-3'
import 'bootstrap/dist/css/bootstrap.css'
import { createI18n } from 'vue-i18n';

function loadLocalMessages() {
    const locales = require.context('./assets/i18n', true, /[A-Za-z0-9-_,\s]+\.json$/i);
    const messages = {};
    locales.keys().forEach(key => {
        const matched = key.match(/([A-Za-z0-9-_]+)\./i);
        if (matched && matched.length > 1) {
            const locale = matched[1];
            messages[locale] = locales(key).default;
        }
    });
    return messages;
}

// const messages = {
//         en: {
//             message: {
//                 hello: 'Hello World'
//             }
//     },
//         pl: {
//             message: {
//                 hello: 'Cześć'
//             }
//     }
// };
 
const i18n = createI18n({
        locale: 'en',
        fallbackLocale: 'en',
        messages: loadLocalMessages()
});
 
 
const app = createApp(App);
 
app.use(BootstrapVue3);
app.use(IconsPlugin);
app.use(router);
app.use(i18n);
app.mount('#app');