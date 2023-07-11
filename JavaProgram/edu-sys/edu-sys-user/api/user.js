import request from "../utils/request";

export default {

  /**
   * 注册用户
   * @param data 用户信息
   * @returns {*}
   */
  register(data) {
    return request({
      url: '/user-service/student-member/register',
      method: 'post',
      data
    });
  },
  /**
   * 获取验证码
   */
  getCodeFun(phone) {
    return request({
      url: '/sms-service/edu-sms/sendMessage/' + phone,
      method: 'get'
    });
  },
  /**
   * 登录
   * @param data 用户信息
   * @returns {*}
   **/
  login(data) {
    return request({
      url: '/user-service/student-member/login',
      method: 'post',
      data
    });
  },
  /**
   * 根据token获取用户信息
   * @param token
   */
  getUserInfo(token) {
    return request({
      url: '/user-service/student-member/getMemberByToken',
      method: 'get'
    });
  }
}
