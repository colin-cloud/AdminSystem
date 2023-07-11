import request from "../utils/request";

export default {
  /**
   * 获取4个banner
   * @returns {*}
   */
  getBanners() {
    return request({
      url: '/cms-service/cms-banner-front/getBanners',
      method: 'get'
    });
  }
}
