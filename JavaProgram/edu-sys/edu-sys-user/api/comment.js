import request from "../utils/request";

export default {
  /**
   * 分页评论
   * @param pageSize 一页数目
   * @param pageNum 当前页
   * @param sort 排序规则
   * @returns {AxiosPromise}
   */
  pageComments(pageSize, pageNum, sort, courseId) {
    return request({
      url: '/edu-service/edu-comment/pageComments',
      method: 'get',
      params: {
        pageSize,
        pageNum,
        sort,
        courseId
      }
    });
  },
  /**
   * 新增评论
   * @param data
   * @returns {AxiosPromise}
   */
  insertComment(data) {
    return request({
      url: '/edu-service/edu-comment/insertComment',
      method: 'post',
      data
    });
  },
  /**
   * 根据id删除评论
   * @param id
   */
  removeById(id) {
    return request({
      url: '/edu-service/edu-comment/insertComment',
      method: 'post',
      data
    });
  }
}
