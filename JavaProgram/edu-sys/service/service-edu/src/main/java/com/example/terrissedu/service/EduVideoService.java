package com.example.terrissedu.service;

import com.example.terrissedu.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
public interface EduVideoService extends IService<EduVideo> {

    Boolean removeByCourseId(Long courseId);
}
