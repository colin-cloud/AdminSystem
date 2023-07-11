package com.example.terrissedu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.terrissedu.entity.EduTeacher;
import com.example.terrissedu.entity.vo.TeacherQuery;
import com.example.terrissedu.service.EduTeacherService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultCode;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/edu-service/edu-teacher")
@CrossOrigin
@Slf4j
@PropertySource("classpath:application.yml")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @Value("${file.path}")
    private String FILE_PATH;

    // 后台管理接口
    @PutMapping("/updateTeacher")
    @ApiOperation("更新信息")
    public CommonResult<Boolean> updateTeacher(@RequestBody EduTeacher teacher) {
        // 根据id查询信息
        boolean flag = eduTeacherService.updateById(teacher);
        CommonResult<Boolean> res = new CommonResult<>();
        res.success(ResultMessage.UPDATE_TEACHER_ERROR, flag);
        return res;
    }

    @PostMapping("/fuzzyQueryAndPage")
    @ApiOperation("分页模糊查询讲师数据")
    public CommonResult<IPage<EduTeacher>> pageTeachers(@RequestParam("pageSize")
                                                        @ApiParam(name = "pageSize", value = "当前页总数", required = true)Integer pageSize,
                                                        @RequestParam("pageNum")
                                                        @ApiParam(name = "pageNum", value = "当前页码", required = true)Integer pageNum,
                                                        @RequestBody(required = false)
                                                                    TeacherQuery query) {
        return eduTeacherService.pageTeachers(pageSize, pageNum, query);
    }

    // 添加讲师信息
    @PostMapping("/insertTeacher")
    @ApiOperation("添加讲师")
    public CommonResult<Boolean> insertTeacher(@RequestBody EduTeacher teacher) {
        CommonResult<Boolean> res = new CommonResult<>();
        boolean flag = eduTeacherService.save(teacher);
        if (flag) {
            res.success(ResultMessage.INSERT_TEACHERS_SUCCESS, true);
        } else {
            res.error(ResultMessage.INSERT_TEACHERS_ERROR);
        }
        return res;
    }

    // 分页查询讲师数据
    @GetMapping("/pageTeachers")
    @ApiOperation("分页查询讲师数据")
    public CommonResult<IPage<EduTeacher>> pageTeachers(@RequestParam("pageSize") Integer pageSize,
                                                        @RequestParam("pageNum") Integer pageNum) {
        // 创建page对象
        IPage<EduTeacher> pageTeachers = new Page<>(pageNum, pageSize);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("level")
                .orderByAsc("create_time");
        eduTeacherService.page(pageTeachers, wrapper);
        CommonResult<IPage<EduTeacher>> res = new CommonResult<>();
        res.success(ResultMessage.PAGE_TEACHERS_SUCCESS, pageTeachers);
        return res;
    }

    // 查询讲师表所有数据
    @GetMapping("/getAllTeachers")
    @ApiOperation("得到所有讲师的列表")
    public CommonResult<List<EduTeacher>> getAllTeachers() {
        CommonResult<List<EduTeacher>> res = new CommonResult<>();
        return res.success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.LIST_TEACHERS_SUCCESS)
                .data(eduTeacherService.list(null));
    }

    @GetMapping("/getTeacherById")
    @ApiOperation("得到指定的讲师")
    public CommonResult<EduTeacher> getTeacherById(@RequestParam("id") Long id) {
        // 得到信息
        EduTeacher data = eduTeacherService.getById(id);
        CommonResult<EduTeacher> res = new CommonResult<>();
        return res.success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.LIST_TEACHERS_SUCCESS)
                .data(data);
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("逻辑删除")
    public CommonResult<Boolean> removeById(@PathVariable("id")
                                  @ApiParam(name = "id", value = "讲师ID", required = true) Long id) {
        boolean flag = eduTeacherService.removeAndTeacherById(id);
        CommonResult<Boolean> res = new CommonResult<>();
        if (flag) {
            res.success(ResultMessage.DELETE_TEACHER_SUCCESS, true);
        } else {
            res.error(ResultMessage.DELETE_TEACHER_ERROR);
        }
        return res;
    }

    // 前台管理接口
    @GetMapping("/getCountTeachers")
    @ApiOperation("得到热门的四个讲师")
    public CommonResult<List<EduTeacher>> getCountTeachers() {
        return eduTeacherService.getCountTeachers();
    }
}

