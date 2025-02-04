module.exports = {
  devServer: {
    hot: false,
    liveReload: false,
    proxy: {
      "/api": {
        target: "http://20.121.42.213:8080", // Backend Spring Boot
        secure: false, // Jeśli backend nie ma certyfikatu SSL, ustaw na false
        changeOrigin: true, // Ustawia poprawne origin dla backendu
        pathRewrite: { "^/api": "" }, // Usuwa `/api` z adresu URL
      },
    },
  },
};
