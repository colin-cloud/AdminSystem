package com.example.terrissedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.terrissedu.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.terrissedu.entity.vo.CourseQuery;
import com.example.terrissedu.utils.CommonResult;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
public interface EduCourseService extends IService<EduCourse> {

    CommonResult<IPage<EduCourse>> pageCourses(Integer pageSize, Integer pageNum, CourseQuery query);

    CommonResult<IPage<EduCourse>> pageCoursesAllInfo(Integer pageSize, Integer pageNum, CourseQuery query);

    CommonResult<Boolean> removeCourseById(Long id);

    CommonResult<List<EduCourse>> getCountCourses();

    CommonResult<List<EduCourse>> getFourCoursesByTeacherId(Long id);

    CommonResult<IPage<EduCourse>> pageAndSort(Integer pageSize, Integer pageNum, Integer sort, CourseQuery query);

    CommonResult<EduCourse> getCourseInfoById(Long id);

    List<EduCourse> getCoursesByTeacherId(Long id);
}
