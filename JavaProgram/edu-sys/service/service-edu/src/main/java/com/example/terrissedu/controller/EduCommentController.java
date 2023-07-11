package com.example.terrissedu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.terrissedu.entity.EduComment;
import com.example.terrissedu.entity.EduCourse;
import com.example.terrissedu.service.EduCommentService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 评论 前端控制器
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Api(tags = "评论管理")
@RestController
@RequestMapping("/edu-service/edu-comment")
@CrossOrigin
public class EduCommentController {

    @Autowired
    private EduCommentService commentService;

    @ApiOperation("分页获取评论")
    @GetMapping("/pageComments")
    public CommonResult<IPage<EduComment>> pageComments(@RequestParam("pageSize") Integer pageSize,
                                                        @RequestParam("pageNum") Integer pageNum,
                                                        @RequestParam("sort") Integer sort,
                                                        @RequestParam("courseId") Long courseId) {
        IPage<EduComment> page = new Page<>(pageNum, pageSize);
        QueryWrapper<EduComment> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        // sort -- 0 最热 - 1 最新
        switch (sort) {
            case 0:
                wrapper.orderByDesc("star");
                break;
            case 1:
                wrapper.orderByDesc("create_time");
                break;
            default:
                break;
        }
        commentService.page(page, wrapper);
        return new CommonResult<IPage<EduComment>>().success()
                .message(ResultMessage.PAGE_COMMENT_SUCCESS)
                .data(page);
    }

    @PostMapping("/insertComment")
    @ApiOperation("添加评论")
    public CommonResult<EduComment> insertComment(@RequestBody EduComment comment) {
        CommonResult<EduComment> res = new CommonResult<>();
        boolean flag = commentService.save(comment);
        if (flag) {
            res.success(ResultMessage.INSERT_COMMENT_SUCCESS, comment);
        } else {
            res.error(ResultMessage.INSERT_COMMENT_ERROR);
        }
        return res;
    }

    @DeleteMapping("/removeById/{id}")
    @ApiOperation("逻辑删除评论")
    public CommonResult<Boolean> removeById(@PathVariable("id")
                                            @ApiParam(name = "id", value = "讲师ID", required = true) Long id) {
        boolean flag = commentService.removeById(id);
        CommonResult<Boolean> res = new CommonResult<>();
        if (flag) {
            res.success(ResultMessage.DELETE_COMMENT_SUCCESS, true);
        } else {
            res.error(ResultMessage.DELETE_COMMENT_ERROR);
        }
        return res;
    }
}

