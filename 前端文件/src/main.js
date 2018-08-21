import Vue from 'vue'
import App from './App'
import router from './router'

import axios from 'axios'
import VueAxios from 'vue-axios'
import $ from 'jquery'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min'
import './assets/commen.css'

Vue.prototype.host = 'http://127.0.0.1:8080/api/1'
axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8'

Vue.use(VueAxios, axios)

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
