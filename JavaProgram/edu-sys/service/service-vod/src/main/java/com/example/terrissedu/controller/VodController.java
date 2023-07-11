package com.example.terrissedu.controller;

import com.example.terrissedu.service.VodService;
import com.example.terrissedu.utils.CommonResult;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author Terriss
 * @time 2023-07-04 15:53:21
 * @description TODO
 */
@RestController
@RequestMapping("/edu-vod/vod")
@CrossOrigin
public class VodController {

    @Autowired
    private VodService vodService;

    @PostMapping("/upload")
    @ApiOperation("上传视频")
    public CommonResult<Map<String, String>> upload(MultipartFile file) {
        return vodService.uploadVideo(file);
    }

    @DeleteMapping("/removeByVideoId/{videoId}")
    @ApiOperation("删除视频")
    public CommonResult<Boolean> removeByVideoId(@PathVariable("videoId")
                                                 @ApiParam(name = "videoId", value = "视频id", required = true) String videoId) {
        return vodService.removeVideo(videoId);
    }

    @GetMapping("/getVideoIdById")
    @ApiOperation("获取视频凭证")
    public CommonResult<String> getVideoIdById(@RequestParam("id") String id) {
        return vodService.getVideoIdById(id);
    }
}
