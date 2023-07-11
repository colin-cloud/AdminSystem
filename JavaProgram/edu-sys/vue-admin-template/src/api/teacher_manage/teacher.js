import request from '@/utils/request'

export default  {
  /**
   * 模糊查询且分页
   * @param pageSize 当前页的容量
   * @param pageNum 当前页码
   * @param data 模糊查询信息
   * @returns {AxiosPromise}
   */
  page(pageSize, pageNum, data) {
    return request({
      url: '/edu-service/edu-teacher/fuzzyQueryAndPage',
      method: 'post',
      params: {
        pageSize,
        pageNum
      },
      data
    });
  },
  /**
   * 添加讲师
   * @param data 讲师信息
   */
  insertTeacher(data) {
    return request({
      url: '/edu-service/edu-teacher/insertTeacher',
      method: 'post',
      data
    });
  },
  /**
   * 逻辑删除讲师
   * @param id 讲师id
   * @returns {AxiosPromise}
   */
  removeTeacher(id) {
    return request({
      url: `/edu-service/edu-teacher/removeById/${id}`,
      method: 'delete'
    });
  },
  /**
   * 更新讲师信息
   * @param data 讲师信息
   * @returns {AxiosPromise}
   */
  updateTeacher(data) {
    return request({
      url: '/edu-service/edu-teacher/updateTeacher',
      method: 'put',
      data
    });
  },
  /**
   * 根据id查询teacher对象
   * @param id teacher的id
   */
  getTeacherById(id) {
    return request({
      url: '/edu-service/edu-teacher/getTeacherById',
      method: 'get',
      params: {
        id
      }
    });
  },
  /**
   * 获取所有讲师
   * @returns {AxiosPromise}
   */
  getAllTeachers() {
    return request({
      url: '/edu-service/edu-teacher/getAllTeachers',
      method: 'get'
    });
  }
}
