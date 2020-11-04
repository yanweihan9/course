import Vue from 'vue'
import App from './App.vue'
import router from './router'
import filter from './filter/filter'

import axios from 'axios'

Vue.prototype.$ajax = axios;
Vue.config.productionTip = false;

axios.interceptors.request.use(function (config) {
  console.log("请求：", config);
  return config;
}, error => {
});

axios.interceptors.response.use(function (response) {
  console.log("返回结果：", response);
  return response;
}, error => {
});

//全局过滤器
Object.keys(filter).forEach(key => {
  Vue.filter(key,filter[key])
});

new Vue({
  router,
  render: h => h(App),
}).$mount('#app');

console.log("环境：",process.env.NODE_ENV);
