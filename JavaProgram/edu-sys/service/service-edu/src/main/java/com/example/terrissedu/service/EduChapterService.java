package com.example.terrissedu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.terrissedu.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.terrissedu.entity.EduCourse;
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
public interface EduChapterService extends IService<EduChapter> {

    List<EduChapter> getAllChaptersByCourseID(Long courseId);

    boolean removeByCourseId(Long courseId);
}
