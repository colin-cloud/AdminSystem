import request from '@/utils/request'

export default  {
  /**
   * 向后端接口发送请求，插入数据库
   * @param data 课程信息
   * @returns {AxiosPromise} 结果
   */
  insertCourse(data) {
    return request({
      url: '/edu-service/edu-course/insertCourse',
      method: 'post',
      data
    });
  },
  /**
   * 向后端请求分页
   */
  page(pageSize, pageNum, data) {
    return request({
      url: '/edu-service/edu-course/fuzzyQueryAndPage',
      method: 'post',
      data,
      params: {
        pageSize,
        pageNum
      }
    });
  },
  /**
   * 根据id删除对应的课程
   * @param id
   */
  removeCourse(id) {
    return request({
      url: `/edu-service/edu-course/removeById/${id}`,
      method: 'delete'
    });
  },
  /**
   * 更新课程信息
   * @param data 课程
   */
  updateCourse(data) {
    return request({
      url: `/edu-service/edu-course/updateCourse`,
      method: 'put',
      data
    });
  }
}
