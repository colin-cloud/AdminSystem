package com.example.terrissedu.controller;


import com.example.terrissedu.entity.EduSubject;
import com.example.terrissedu.entity.dto.Subject;
import com.example.terrissedu.service.EduSubjectService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Api(tags = "课程管理")
@RestController
@RequestMapping("/edu-service/edu-subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    @PostMapping("/insertSubjectByFile")
    public CommonResult<Boolean> insertSubjectByFile(MultipartFile file) {
        CommonResult<Boolean> res = new CommonResult<>();
        subjectService.insertSubjectByFile(file);
        return res.success().message(ResultMessage.EXCEL_WRITE_SUCCESS).data(true);
    }

    @GetMapping("/getAllSubjects")
    public CommonResult<List<Subject>> getAllSubjects() {
        CommonResult<List<Subject>> res = new CommonResult<>();
        List<Subject> subjects = subjectService.getAllSubjects();
        return res.success().message(ResultMessage.SUBJECT_QUERY_SUCCESS).data(subjects);
    }

    // 前台
    @GetMapping("/getSecondList/{id}")
    public CommonResult<List<EduSubject>> getSecondList(@PathVariable("id") Long id) {
        return subjectService.getSecondList(id);
    }
}

