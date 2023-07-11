package com.example.terrissedu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.terrissedu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.terrissedu.entity.vo.TeacherQuery;
import com.example.terrissedu.utils.CommonResult;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
public interface EduTeacherService extends IService<EduTeacher> {
    CommonResult<IPage<EduTeacher>> pageTeachers(Integer pageSize, Integer pageNum, TeacherQuery query);

    CommonResult<List<EduTeacher>> getCountTeachers();

    boolean removeAndTeacherById(Long id);
}
