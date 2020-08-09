import Vue from 'vue'
import App from './App.vue'
import router from './router'

import axios from 'axios'

import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import 'bootstrap/dist/js/bootstrap.min.js'
import 'font-awesome/css/font-awesome.min.css'

//这里就是对组件的绑定
import theConfirm from './components/confirm.js'
Vue.prototype.$confirm = theConfirm;


Vue.config.productionTip = false

Vue.prototype.$http = axios    //全局注册，使用方法为:this.$http

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
