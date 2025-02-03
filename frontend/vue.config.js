// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({

//   transpileDependencies: true
// })


module.exports = {
  devServer: {
    hot: false,
    liveReload: false,
    proxy: {
      '/api': { //każde żądanie zaczynającie się od /api będzie przekierowane
        target: 'http://135.224.16.69:8080', //docelowy backend działa porcie 8080
        changeOrigin: true, //podmiana nagłówka origin w żądaniu
        pathRewrite: {'^/api':''}, //usuwamy /api z url przed przekazaniem do backendu
        ws: false //wyłącza websocket
      },
    },
    client: {
      webSocketURL: 'auto://0.0.0.0/ws'
    }
  }
}