package com.example.terrissedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.terrissedu.entity.EduCourse;
import com.example.terrissedu.entity.EduTeacher;
import com.example.terrissedu.entity.vo.CourseQuery;
import com.example.terrissedu.entity.vo.TeacherQuery;
import com.example.terrissedu.mapper.EduCourseMapper;
import com.example.terrissedu.service.EduChapterService;
import com.example.terrissedu.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.terrissedu.service.EduVideoService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultCode;
import com.example.terrissedu.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Service
public class EduCourseServiceImpl
        extends ServiceImpl<EduCourseMapper, EduCourse>
        implements EduCourseService {

    @Autowired
    private EduCourseMapper courseMapper;

    @Autowired
    private EduVideoService videoService;

    @Autowired
    private EduChapterService chapterService;

    @Override
    public CommonResult<IPage<EduCourse>> pageCourses(Integer pageSize,
                                                      Integer pageNum, CourseQuery query) {
        // 创建page对象
        IPage<EduCourse> page = new Page<>(pageNum, pageSize);
        // 创建查询方法
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(query.getTitle())) {
            wrapper.like("title", query.getTitle());
        }
        if (!StringUtils.isEmpty(query.getTeacherName())) {
            wrapper.eq("teacher_name", query.getTeacherName());
        }
        if (StringUtils.hasLength(query.getBegin())) {
            wrapper.ge("create_time", query.getBegin());
        }
        if (StringUtils.hasLength(query.getEnd())) {
            wrapper.le("create_time", query.getEnd());
        }
        // 排序
        wrapper.orderByDesc("create_time");

        CommonResult<IPage<EduCourse>> res = new CommonResult<>();
        res.success(ResultMessage.PAGE_COURSES_SUCCESS, page);
        return res;
    }

    @Override
    public CommonResult<IPage<EduCourse>> pageCoursesAllInfo(Integer pageSize,
                                                             Integer pageNum, CourseQuery query) {
        // 创建page对象
        IPage<EduCourse> page = new Page<>(pageNum, pageSize);

        courseMapper.pageCoursesInfos(page, query);

        CommonResult<IPage<EduCourse>> res = new CommonResult<>();
        res.success(ResultMessage.PAGE_COURSES_SUCCESS, page);
        return res;
    }

    @Override
    public CommonResult<Boolean> removeCourseById(Long id) {
        // 先删除小节 -- 删除视频
        Boolean removeVideo = videoService.removeByCourseId(id);
        // 再删除章节
        boolean removeChapter = chapterService.removeByCourseId(id);
        // 再删除课程
        boolean flag = this.removeById(id);
        CommonResult<Boolean> res = new CommonResult<>();
        if (flag) {
            res.success(ResultMessage.DELETE_COURSE_SUCCESS, true);
        } else {
            res.error(ResultMessage.DELETE_COURSE_ERROR);
        }
        return res;
    }

    @Override
    @Cacheable(value = "courses", key = "'getCountCourses'")
    public CommonResult<List<EduCourse>> getCountCourses() {
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("view_count")
                .last("limit 8");
        return new CommonResult<List<EduCourse>>().success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.LIST_COURSES_SUCCESS)
                .data(list(wrapper));
    }

    @Override
    public CommonResult<List<EduCourse>> getFourCoursesByTeacherId(Long id) {
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id", id)
                .orderByDesc("view_count")
                .last("limit 4");
        return new CommonResult<List<EduCourse>>().success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.LIST_COURSES_SUCCESS)
                .data(list(wrapper));
    }

    @Override
    public CommonResult<IPage<EduCourse>> pageAndSort(Integer pageSize, Integer pageNum,
                                                      Integer sort, CourseQuery query) {
        // 创建page对象
        IPage<EduCourse> page = new Page<>(pageNum, pageSize);

        courseMapper.pageCoursesInfosAndSort(page, query, sort);
        return new CommonResult<IPage<EduCourse>>().success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.PAGE_COURSES_SUCCESS)
                .data(page);

    }

    @Override
    public CommonResult<EduCourse> getCourseInfoById(Long id) {
        EduCourse course = courseMapper.getCourseInfoById(id);
        CommonResult<EduCourse> res = new CommonResult<>();
        return res.success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.LIST_COURSES_SUCCESS)
                .data(course);
    }

    @Override
    public List<EduCourse> getCoursesByTeacherId(Long id) {
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id", id);
        return list(wrapper);
    }
}
