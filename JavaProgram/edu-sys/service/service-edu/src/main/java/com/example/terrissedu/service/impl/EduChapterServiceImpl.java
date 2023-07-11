package com.example.terrissedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.entity.EduChapter;
import com.example.terrissedu.entity.EduVideo;
import com.example.terrissedu.mapper.EduChapterMapper;
import com.example.terrissedu.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.terrissedu.service.EduVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {

    @Autowired
    private EduVideoService videoService;

    @Override
    public List<EduChapter> getAllChaptersByCourseID(Long courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        // 获取所有的章节
        List<EduChapter> res = list(wrapper);
        res.forEach(chapter -> {
            // 根据chapterId来查询对应的小节信息
            QueryWrapper<EduVideo> chapterQueryWrapper = new QueryWrapper<>();
            chapterQueryWrapper.eq("chapter_id", chapter.getId());
            List<EduVideo> videos = videoService.list(chapterQueryWrapper);
            chapter.setChildren(videos);
        });
        return res;
    }

    @Override
    public boolean removeByCourseId(Long courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        return remove(wrapper);
    }
}
