package com.example.terrissedu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.entity.EduCourse;
import com.example.terrissedu.entity.EduVideo;
import com.example.terrissedu.service.EduVideoService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultCode;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Api(tags = "小节管理")
@RestController
@RequestMapping("/edu-service/edu-video")
@CrossOrigin
public class EduVideoController {

    @Autowired
    private EduVideoService videoService;

    @GetMapping("/getCourseByVideoId")
    @ApiOperation("获取课程id")
    public CommonResult<Long> getCourseByVideoId(@RequestParam("videoId") Long videoId) {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("id", videoId)
                .select("course_id");
        Long l = (long)videoService.getObj(wrapper);
        CommonResult<Long> res = new CommonResult<>();
            res.success(ResultMessage.UPDATE_VIDEO_SUCCESS, l);
        return res;
    }

    @PutMapping("/updateVideo")
    @ApiOperation("更新章节信息")
    public CommonResult<Boolean> updateVideo(@RequestBody EduVideo video) {
        // 根据id查询信息
        boolean flag = videoService.updateById(video);
        CommonResult<Boolean> res = new CommonResult<>();
        if (flag) {
            res.success(ResultMessage.UPDATE_VIDEO_SUCCESS, true);
        } else {
            res.error(ResultMessage.UPDATE_VIDEO_ERROR);
        }
        return res;
    }

    @PostMapping("/insertVideo")
    @ApiOperation("添加小节信息")
    public CommonResult<Boolean> insertVideo(@RequestBody EduVideo video) {
        CommonResult<Boolean> res = new CommonResult<>();
        boolean flag = videoService.save(video);
        if (flag) {
            res.success(ResultMessage.INSERT_VIDEO_SUCCESS, true);
        } else {
            res.error(ResultMessage.INSERT_VIDEO_ERROR);
        }
        return res;
    }

    @GetMapping("/getAllVideos")
    @ApiOperation("得到所有章节的列表")
    public CommonResult<List<EduVideo>> getAllVideos() {
        CommonResult<List<EduVideo>> res = new CommonResult<>();
        return res.success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.LIST_VIDEOS_SUCCESS)
                .data(videoService.list(null));
    }

    @GetMapping("/getVideoById")
    @ApiOperation("得到指定的小节信息")
    public CommonResult<EduVideo> getVideoById(@RequestParam("id") Long id) {
        // 得到信息
        EduVideo data = videoService.getById(id);
        CommonResult<EduVideo> res = new CommonResult<>();
        return res.success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.LIST_VIDEOS_SUCCESS)
                .data(data);
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("删除小节")
    public CommonResult<Boolean> removeById(@PathVariable("id")
                                            @ApiParam(name = "id", value = "小节id", required = true) Long id) {
        boolean flag = videoService.removeById(id);
        CommonResult<Boolean> res = new CommonResult<>();
        if (flag) {
            res.success(ResultMessage.DELETE_VIDEO_SUCCESS, true);
        } else {
            res.error(ResultMessage.DELETE_VIDEO_ERROR);
        }
        return res;
    }
}

