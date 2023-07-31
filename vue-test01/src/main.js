
import Vue from 'vue'
import App from './App'
import router from './router'

import axios from 'axios'
/*引入如下组件*/
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

const service = axios.create({
  baseURL: "http://localhost:8081", //全局基本的url
  timeout: 5000 //连接断开的时间
})

export default service;
Vue.use(ElementUI);

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
