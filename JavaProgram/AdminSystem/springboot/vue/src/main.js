import Vue from 'vue';
import App from './App.vue';
import router from './router';

//使用elementUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

//引入全局css
import './assets/global.css';
//引入工具js文件 -- 请求相关
import request from "@/utils/request";

Vue.config.productionTip = false;

//使用ElementUi插件
Vue.use(ElementUI, {size: "small"});

Vue.prototype.request = request;

new Vue({
  router,
  render: h => h(App)
}).$mount('#app');
