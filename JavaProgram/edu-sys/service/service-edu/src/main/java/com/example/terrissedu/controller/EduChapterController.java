package com.example.terrissedu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.entity.EduChapter;
import com.example.terrissedu.entity.EduVideo;
import com.example.terrissedu.service.EduChapterService;
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
 * 课程 前端控制器
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Api(tags = "章节管理")
@RestController
@RequestMapping("/edu-service/edu-chapter")
@CrossOrigin
public class EduChapterController {

    @Autowired
    private EduChapterService chapterService;

    @Autowired
    private EduVideoService videoService;

    @PostMapping("/insertChapters")
    @ApiOperation("批量添加章节信息")
    public CommonResult<Boolean> insertChapters(@RequestBody List<EduChapter> chapters) {
        CommonResult<Boolean> res = new CommonResult<>();
        for (EduChapter chapter : chapters) {
            chapterService.save(chapter);
            long id = chapter.getId();
            for (EduVideo video : chapter.getChildren()) {
                video.setChapterId(id);
                videoService.save(video);
            }
        }
        return res.success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.INSERT_COURSES_SUCCESS)
                .data(true);
    }

    @PutMapping("/updateChapter")
    @ApiOperation("更新章节信息")
    public CommonResult<Boolean> updateChapter(@RequestBody EduChapter chapter) {
        // 根据id查询信息
        boolean flag = chapterService.updateById(chapter);
        CommonResult<Boolean> res = new CommonResult<>();
        if (flag) {
            res.success(ResultMessage.UPDATE_CHAPTER_SUCCESS, true);
        } else {
            res.error(ResultMessage.UPDATE_CHAPTER_ERROR);
        }
        return res;
    }

    @PostMapping("/insertChapter")
    @ApiOperation("添加章节信息")
    public CommonResult<Boolean> insertChapter(@RequestBody EduChapter chapter) {
        CommonResult<Boolean> res = new CommonResult<>();
        boolean flag = chapterService.save(chapter);
        if (flag) {
            for (EduVideo video : chapter.getChildren()) {
                video.setChapterId(chapter.getId());
                videoService.save(video);
            }
            res.success(ResultMessage.INSERT_CHAPTER_SUCCESS, true);
        } else {
            res.error(ResultMessage.INSERT_CHAPTER_ERROR);
        }
        return res;
    }

    @GetMapping("/getAllChaptersByCourseID/{courseId}")
    @ApiOperation("根据课程id得到所有章节的列表")
    public CommonResult<List<EduChapter>> getAllChaptersByCourseID(@PathVariable("courseId")
                                                                               Long courseId) {
        CommonResult<List<EduChapter>> res = new CommonResult<>();
        List<EduChapter> chapters = chapterService.getAllChaptersByCourseID(courseId);
        return res.success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.LIST_CHAPTERS_SUCCESS)
                .data(chapters);
    }

    @GetMapping("/getChapterById")
    @ApiOperation("得到指定的课程信息")
    public CommonResult<EduChapter> getChapterById(@RequestParam("id") Long id) {
        // 得到信息
        EduChapter data = chapterService.getById(id);
        CommonResult<EduChapter> res = new CommonResult<>();
        return res.success()
                .code(ResultCode.SUCCESS)
                .message(ResultMessage.LIST_CHAPTERS_SUCCESS)
                .data(data);
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("删除章节")
    public CommonResult<Boolean> removeById(@PathVariable("id")
                                            @ApiParam(name = "id", value = "课程", required = true) Long id) {
        boolean flag = chapterService.removeById(id);
        CommonResult<Boolean> res = new CommonResult<>();
        if (flag) {
            res.success(ResultMessage.DELETE_CHAPTER_SUCCESS, true);
        } else {
            res.error(ResultMessage.DELETE_CHAPTER_ERROR);
        }
        return res;
    }
}

