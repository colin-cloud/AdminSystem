package com.example.terrissedu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.terrissedu.entity.EduCourse;
import com.example.terrissedu.entity.vo.CourseQuery;
import com.example.terrissedu.service.EduCourseService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultCode;
import com.example.terrissedu.utils.ResultMessage;
import com.example.terrissedu.utils.dto.CourseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Api(tags = "课程列表管理")
@RestController
@RequestMapping("/edu-service/edu-course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    // 后台管理接口
    @PutMapping("/updateCourse")
    @ApiOperation("更新课程信息-后台")
    public CommonResult<Boolean> updateCourse(@RequestBody EduCourse course) {
        // 根据id查询信息
        boolean flag = courseService.updateById(course);
        CommonResult<Boolean> res = new CommonResult<>();
        if (flag) {
            res.success(ResultMessage.UPDATE_COURSE_SUCCESS, true);
        } else {
            res.error(ResultMessage.UPDATE_COURSE_ERROR);
        }
        return res;
    }

    @PostMapping("/fuzzyQueryAndPage")
    @ApiOperation("分页模糊查询课程信息-后台")
    public CommonResult<IPage<EduCourse>> pageCourses(@RequestParam("pageSize")
                                                        @ApiParam(name = "pageSize", value = "当前页总数", required = true)Integer pageSize,
                                                        @RequestParam("pageNum")
                                                        @ApiParam(name = "pageNum", value = "当前页码", required = true)Integer pageNum,
                                                        @RequestBody(required = false)
                                                              CourseQuery query) {
        return courseService.pageCoursesAllInfo(pageSize, pageNum, query);
    }

    @PostMapping("/insertCourse")
    @ApiOperation("添加课程-后台")
    public CommonResult<String> insertCourse(@RequestBody EduCourse course) {
        CommonResult<String> res = new CommonResult<>();
        boolean flag = courseService.save(course);
        if (flag) {
            res.success(ResultMessage.INSERT_COURSES_SUCCESS, course.getId() + "");
        } else {
            res.error(ResultMessage.INSERT_COURSES_ERROR);
        }
        return res;
    }

    @GetMapping("/pageCourses")
    @ApiOperation("分页查询课程数据-后台")
    public CommonResult<IPage<EduCourse>> pageCourses(@RequestParam("pageSize") Integer pageSize,
                                                        @RequestParam("pageNum") Integer pageNum) {
        // 创建page对象
        IPage<EduCourse> pageCourses = new Page<>(pageNum, pageSize);
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("view_count");
        courseService.page(pageCourses, wrapper);
        CommonResult<IPage<EduCourse>> res = new CommonResult<>();
        res.success(ResultMessage.PAGE_COURSES_SUCCESS, pageCourses);
        return res;
    }

    // 查询讲师表所有数据
    @GetMapping("/getAllCourses")
    @ApiOperation("得到所有课程的列表-后台")
    public CommonResult<List<EduCourse>> getAllCourses() {
        CommonResult<List<EduCourse>> res = new CommonResult<>();
        return res.success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.LIST_COURSES_SUCCESS)
                .data(courseService.list(null));
    }

    @GetMapping("/getCourseById")
    @ApiOperation("得到指定的课程信息-后台")
    public CommonResult<EduCourse> getCourseById(@RequestParam("id") Long id) {
        // 得到信息
        return courseService.getCourseInfoById(id);
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("逻辑删除-后台")
    public CommonResult<Boolean> removeById(@PathVariable("id")
                                            @ApiParam(name = "id", value = "课程", required = true) Long id) {
        return courseService.removeCourseById(id);
    }

    // 前台管理接口
    @GetMapping("/getCountCourses")
    @ApiOperation("得到8个热门课程-后台")
    public CommonResult<List<EduCourse>> getCountCourses() {
        return courseService.getCountCourses();
    }

    @GetMapping("/getCoursesByTeacherId/{id}")
    @ApiOperation("根据讲师id获取对应的四个热门课程")
    public CommonResult<List<EduCourse>> getCoursesByTeacherId(@PathVariable("id") Long id) {
        return courseService.getFourCoursesByTeacherId(id);
    }

    @PostMapping("/fuzzQuery")
    @ApiOperation("分页模糊查询课程信息并排序-后台")
    public CommonResult<IPage<EduCourse>> fuzzQuery(@RequestParam("pageSize")
                                                      @ApiParam(name = "pageSize", value = "当前页总数", required = true)Integer pageSize,
                                                      @RequestParam("pageNum")
                                                      @ApiParam(name = "pageNum", value = "当前页码", required = true)Integer pageNum,
                                                      @RequestParam("sort")
                                                      @ApiParam(name = "sort", value = "排序", required = true)Integer sort,
                                                      @RequestBody(required = false)
                                                              CourseQuery query) {
        return courseService.pageAndSort(pageSize, pageNum, sort, query);
    }


    // 返回CourseDTO对象功service-order使用
    @GetMapping("/getCourseByCourseId/{courseId}")
    public CourseDTO getCourseByCourseId(@PathVariable("courseId") Long courseId) {
        EduCourse data = courseService.getCourseInfoById(courseId).getData();

        // 赋值到CourseDTO中
        CourseDTO res = new CourseDTO();
        BeanUtils.copyProperties(data, res);

        return res;
    }

    // 更新销量
    @PutMapping("/updateCourseSaleCount")
    public CommonResult<Boolean> updateCourseSaleCount(@RequestParam("courseId") Long courseId) {
        EduCourse course = courseService.getById(courseId);
        course.setSaleCount(course.getSaleCount() + 1);
        boolean res = courseService.updateById(course);
        return new CommonResult<Boolean>().success()
                .code(ResultCode.SUCCESS)
                .data(res);
    }

    // 更新观看量
    @PutMapping("/updateCourseViewCount")
    public CommonResult<Boolean> updateCourseViewCount(@RequestParam("courseId") Long courseId) {
        EduCourse course = courseService.getById(courseId);
        course.setSaleCount(course.getViewCount() + 1);
        boolean res = courseService.updateById(course);
        return new CommonResult<Boolean>().success()
                .code(ResultCode.SUCCESS)
                .data(res);
    }
}

