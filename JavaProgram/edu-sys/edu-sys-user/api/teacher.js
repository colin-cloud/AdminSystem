import request from "../utils/request";

export default {

  /**
   * 获取4个名师
   * @returns {*}
   */
  getCountTeachers() {
    return request({
      url: '/edu-service/edu-teacher/getCountTeachers',
      method: 'get'
    });
  },
  /**
   * 分页查询讲师
   */
  pageTeachers(pageSize, pageNum) {
    return request({
      url: '/edu-service/edu-teacher/pageTeachers',
      method: 'get',
      params: {
        pageSize,
        pageNum
      }
    });
  },
  /**
   * 根据id获取讲师
   * @param id
   */
  getTeacherById(id) {
    return request({
      url: '/edu-service/edu-teacher/getTeacherById',
      method: 'get',
      params: {
        id
      }
    });
  }
}
