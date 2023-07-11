package com.example.terrissedu.service;

import com.example.terrissedu.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.terrissedu.entity.dto.Subject;
import com.example.terrissedu.utils.CommonResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
public interface EduSubjectService extends IService<EduSubject> {

    void insertSubjectByFile(MultipartFile file);

    List<Subject> getAllSubjects();

    CommonResult<List<EduSubject>> getSecondList(Long id);

}
