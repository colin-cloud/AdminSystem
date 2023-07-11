import request from '@/utils/request'

export default  {
  /**
   * 向后端接口发送请求，根据课程id获取章节和小节内容
   * @param courseId courseId
   * @returns {AxiosPromise} 章节和小节内容
   */
  getAllChaptersByCourseID(courseId) {
    return request({
      url: `/edu-service/edu-chapter/getAllChaptersByCourseID/${courseId}`,
      method: 'get',
    });
  },
  /**
   * 向数据库中添加章节信息
   * @param chapters 章节列表
   * @returns {AxiosPromise}
   */
  insertChapter(chapter) {
    return request({
      url: `/edu-service/edu-chapter/insertChapter`,
      method: 'post',
      data: chapter
    });
  }
}
