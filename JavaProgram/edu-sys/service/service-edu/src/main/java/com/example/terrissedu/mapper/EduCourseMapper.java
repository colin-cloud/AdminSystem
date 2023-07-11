package com.example.terrissedu.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.terrissedu.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.terrissedu.entity.vo.CourseQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Mapper
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    IPage<EduCourse> pageCoursesInfos(IPage<EduCourse> page,@Param("query") CourseQuery query);

    IPage<EduCourse> pageCoursesInfosAndSort(IPage<EduCourse> page,
                                             @Param("query") CourseQuery query,
                                             Integer sort);

    EduCourse getCourseInfoById(Long id);
}
