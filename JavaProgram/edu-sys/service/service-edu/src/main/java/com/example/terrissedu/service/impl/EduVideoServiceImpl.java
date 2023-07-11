package com.example.terrissedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.client.VodClient;
import com.example.terrissedu.entity.EduVideo;
import com.example.terrissedu.mapper.EduVideoMapper;
import com.example.terrissedu.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo>
        implements EduVideoService {

    @Autowired
    private VodClient vodClient;

    @Override
    public Boolean removeByCourseId(Long courseId) {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        // 删除小节并删除视频
        // 从数据库中查出数据
        List<EduVideo> videos = list(wrapper);
        for (EduVideo video : videos) {
            // 遍历删除
            String videoSourceId = video.getVideoSourceId();
            if (StringUtils.hasLength(videoSourceId)) {
                vodClient.removeByVideoId(videoSourceId);
            }
        }
        return remove(wrapper);
    }
}
