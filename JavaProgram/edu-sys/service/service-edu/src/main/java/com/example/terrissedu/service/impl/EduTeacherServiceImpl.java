package com.example.terrissedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.terrissedu.entity.EduCourse;
import com.example.terrissedu.entity.EduTeacher;
import com.example.terrissedu.entity.vo.TeacherQuery;
import com.example.terrissedu.mapper.EduTeacherMapper;
import com.example.terrissedu.service.EduCourseService;
import com.example.terrissedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

import static jdk.nashorn.internal.objects.NativeMath.log;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Service
@Slf4j
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher>
        implements EduTeacherService {

    @Autowired
    private EduCourseService courseService;

    @Override
    public CommonResult<IPage<EduTeacher>> pageTeachers(Integer pageSize,
                                                        Integer pageNum,
                                                        TeacherQuery query) {
        // 创建page对象
        IPage<EduTeacher> page = new Page<>(pageNum, pageSize);
        // 创建查询方法
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(query.getName())) {
            wrapper.like("name", query.getName());
        }
        if (!StringUtils.isEmpty(query.getLevel())) {
            wrapper.eq("level", query.getLevel());
        }
        if (StringUtils.hasLength(query.getBegin())) {
            wrapper.ge("create_time", query.getBegin());
        }
        if (StringUtils.hasLength(query.getEnd())) {
            wrapper.le("create_time", query.getEnd());
        }
        // 排序
        wrapper.orderByDesc("create_time");

        this.page(page, wrapper);
        CommonResult<IPage<EduTeacher>> res = new CommonResult<>();
        res.success(ResultMessage.PAGE_TEACHERS_SUCCESS, page);
        return res;
    }

    @Override
    @Cacheable(value = "teachers", key = "'getCountTeachers'")
    public CommonResult<List<EduTeacher>> getCountTeachers() {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("level")
                .last("limit 4");
        return new CommonResult<List<EduTeacher>>().success()
                .message(ResultMessage.LIST_TEACHERS_SUCCESS)
                .data(list(wrapper));
    }

    @Override
    public boolean removeAndTeacherById(Long id) {
        // 1. 根据讲师id获取讲师教授的课程
        List<EduCourse> courses = courseService.getCoursesByTeacherId(id);
        // 2. 依次删除course
        courses.forEach(course -> {
            courseService.removeCourseById(course.getId());
        });
        // 3. 删除当前讲师
        return removeById(id);
    }
}
