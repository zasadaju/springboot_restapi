// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({

//   transpileDependencies: true
// })


module.exports = {
  devServer: {
    proxy: {
      '/api': { //każde żądanie zaczynającie się od /api będzie przekierowane
        target: 'http://localhost:8080', //docelowy backend działa porcie 8080
        changeOrigin: true, //podmiana nagłówka origin w żądaniu
        pathRewrite: {'^/api':''}, //usuwamy /api z url przed przekazaniem do backendu
      },
    }
  }
}