import { createApp } from 'vue'
import App from './App.vue'
import router from './router';
import { BootstrapVue3, IconsPlugin } from 'bootstrap-vue-3'
import 'bootstrap/dist/css/bootstrap.css'
import { createI18n } from 'vue-i18n';

import en from './assets/i18n/en.json';

const messages = {
    en: en
    // pl: pl
}

// function loadLocaleMessages() {
//     const locales = require.context('./assets/i18n', true, /[A-Za-z0-9-_,\s]+\.json$/i);
//     const messages = {};
//     console.log("Klucze:", locales.keys());
//     locales.keys().forEach(key => {
//         console.log("Klucze:", locales.key);
//         const matched = key.match(/([A-Za-z0-9-_]+)\.json$/i);
//         console.log("Wynik:", matched);
//         if (matched && matched.length > 1) {
//             const locale = matched[1];
//             messages[locale] = locales(key).default;
//             console.log("Tłumaczenie:", messages[locale]);
//         }
//     });
//     console.log("Wszystko:", messages);
//     return messages;
// }

// const messages = {
// 	en: {
// 	    navbar: {
// 	        about: 'About us'
// 	    }
//     },
// 	pl: {
//         navbar: {
//             about: 'O nas'
//         }
//     }
// };

const i18n = createI18n({
	locale: 'en',
	fallbackLocale: 'en',
	// messages: loadLocaleMessages()
    messages,
}); 

const app = createApp(App);

app.use(BootstrapVue3);
app.use(IconsPlugin);
app.use(router);
app.use(i18n);
app.mount('#app');