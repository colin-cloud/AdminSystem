import request from "../utils/request";

export default {
  getCourseByVideoId(videoId) {
    return request({
      url: '/edu-service/edu-course/updateCourseViewCount',
      method: 'put',
      params: {
        videoId
      }
    });
  },
  updateCourseViewCount(courseId) {
    return request({
      url: '/edu-service/edu-course/updateCourseViewCount',
      method: 'put',
      params: {
        courseId
      }
    });
  },
  updateCourseSaleCount(courseId) {
    return request({
      url: '/edu-service/edu-course/updateCourseSaleCount',
      method: 'put',
      params: {
        courseId
      }
    });
  },
  /**
   * 获取8个热门课程
   * @returns {*}
   */
  getCountCourses() {
    return request({
      url: '/edu-service/edu-course/getCountCourses',
      method: 'get'
    });
  },
  /**
   * 根据讲师id获取其主讲的4个课程
   * @param id
   * @returns {AxiosPromise}
   */
  getCoursesByTeacherId(id) {
    return request({
      url: '/edu-service/edu-course/getCoursesByTeacherId/' + id,
      method: 'get'
    });
  },
  /**
   * 分页查询课程
   */
  pageCourses(pageSize, pageNum, data, sort) {
    return request({
      url: '/edu-service/edu-course/fuzzQuery',
      method: 'post',
      params: {
        pageSize,
        pageNum,
        sort
      },
      data
    });
  },
  /**
   * 获取所有种类
   */
  getSubjects() {
    return request({
      url: '/edu-service/edu-subject/getAllSubjects',
      method: 'get'
    });
  },
  /**
   * 根据id查询二级分类
   * @param id
   */
  getSecondList(id) {
    return request({
      url: '/edu-service/edu-subject/getSecondList/' + id,
      method: 'get'
    });
  },
  /**
   * 根据课程id查询课程
   * @param id
   */
  getCourseById(id) {
    return request({
      url: '/edu-service/edu-course/getCourseById',
      method: 'get',
      params: {
        id
      }
    });
  },
  /**
   * 根据课程id获取章节信息
   * @param id
   * @returns {AxiosPromise}
   */
  getChaptersById(id) {
    return request({
      url: '/edu-service/edu-chapter/getAllChaptersByCourseID/' + id,
      method: 'get'
    });
  },
  /**
   * 根据videoSourceId获取对应的凭证
   * @param id
   */
  getVideoIdById(id) {
    return request({
      url: '/edu-vod/vod/getVideoIdById',
      method: 'get',
      params: {
        id
      }
    });
  }
}
