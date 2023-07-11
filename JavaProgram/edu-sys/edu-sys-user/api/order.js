import request from "../utils/request";

export default {
  isBoughtOneCourse(memberId, courseId) {
    return request({
      url: '/order-service/pay-log/isBoughtOneCourse/',
      method: 'get',
      params: {
        memberId,
        courseId
      }
    });
  },
  getOrderByNo(no) {
    return request({
      url: '/order-service/pay-order/getOrderByNo/' + no,
      method: 'get'
    });
  },
  createOrder(courseId) {
    return request({
      url: '/order-service/pay-order/createOrder/' + courseId,
      method: 'post'
    });
  },
  createWXCode(orderNo) {
    return request({
      url: '/order-service/pay-log/createWXCode',
      method: 'get',
      params: {
        orderNo
      }
    });
  },
  getOrderStatus(no) {
    return request({
      url: '/order-service/pay-order/getOrderStatus/' + no,
      method: 'get'
    });
  }
}
