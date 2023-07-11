import request from '@/utils/request'

export default  {
  /**
   * 获取所有的一级课程分类
   * @returns {AxiosPromise}
   */
  getAllSubjects() {
    return request({
      url: '/edu-service/edu-subject/getAllSubjects',
      method: 'get'
    });
  }
}
