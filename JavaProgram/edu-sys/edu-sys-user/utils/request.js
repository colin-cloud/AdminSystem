import axios from "axios";
import cookie from 'js-cookie'
import {Message} from "element-ui";

// create an axios instance
const request = axios.create({
  baseURL: 'http://192.168.223.132:9001', // url = base url + request url
  // withCredentials: true, // send cookies when cross-domain requests
  timeout: 5000 // request timeout
});

// 设置拦截器
request.interceptors.request.use(
  config => {
    if (cookie.get("user_token")) {
      config.headers['token'] = cookie.get("user_token");
    }
    return config;
  },
  error => {
    return Promise.reject(error);
  });

// 响应拦截器
request.interceptors.response.use(
  response => {
    if (response.data.code === 28004) {
      console.log("response.data.resultCode是28004")
      //返回错误代码-1清除ticket信息并跳转到登录页面
      //debugger
      window.location.href = "/login"
    } else {
      if (response.data.code !== 20000) {
        //25000:订单支付中，不做任何提示
        if (response.data.code !== 25000) {
          Message({
            message: response.data.message,
            type: 'error',
            duration: 5 * 1000
          })
        }
      } else {
        return response;
      }
    }
  }, error => {
    return Promise.reject(error.response);
  });


export default request;
