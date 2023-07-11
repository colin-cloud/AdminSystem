package com.example.terrissedu.controller;


import com.example.terrissedu.service.PayLogService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 支付日志表 前端控制器
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@RestController
@CrossOrigin
@Api(tags = "微信支付管理")
@RequestMapping("/order-service/pay-log")
public class PayLogController {

    @Autowired
    private PayLogService logService;

    @GetMapping("/createWXCode")
    public CommonResult<Map<String, String>> createWXCode(@RequestParam("orderNo") String orderNo) {
        Map<String, String> map = logService.createWXCode(orderNo);
        return new CommonResult<Map<String, String>>()
                .message(ResultMessage.CREATE_CODE_SUCCESS)
                .data(map);
    }

    @ApiOperation("查询用户是否购买某一课程")
    @GetMapping("/isBoughtOneCourse")
    public CommonResult<Boolean> isBoughtOneCourse(@RequestParam("memberId") Long memberId,
                                                   @RequestParam("courseId") Long courseId) {
        boolean res = logService.isBoughtOneCourse(memberId, courseId);
        if (res) {
            return new CommonResult<Boolean>().success()
                    .message(ResultMessage.LOG_EXIST)
                    .data(true);
        } else {
            return new CommonResult<Boolean>().success()
                    .message(ResultMessage.LOG_NOT_EXIST)
                    .data(false);
        }
    }
}

