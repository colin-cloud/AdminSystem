package com.example.terrissedu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.entity.PayOrder;
import com.example.terrissedu.service.PayLogService;
import com.example.terrissedu.service.PayOrderService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Result;
import java.util.Map;

/**
 * <p>
 * 订单 前端控制器
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@RestController
@RequestMapping("/order-service/pay-order")
@Api(tags = "订单管理")
@CrossOrigin
public class PayOrderController {

    @Autowired
    private PayOrderService orderService;

    @Autowired
    private PayLogService logService;


    @ApiOperation("根据订单号查询订单")
    @GetMapping("/getOrderByNo/{no}")
    public CommonResult<PayOrder> getOrderByNo(@PathVariable("no") String no) {
        PayOrder data = orderService.getOrderByNo(no);
        return new CommonResult<PayOrder>().success()
                .message(ResultMessage.SELECT_ORDER_SUCCESS)
                .data(data);
    }

    @ApiOperation("创建订单")
    @PostMapping("/createOrder/{courseId}")
    public CommonResult<String> createOrder(@PathVariable("courseId") Long courseId,
                                              HttpServletRequest request) {
        return orderService.createOrder(courseId, request);
    }

    @ApiOperation("查询订单状态")
    @GetMapping("/getOrderStatus/{no}")
    public CommonResult<Map<String, String>> getOrderStatus(@PathVariable("no") String no) {
        //请求微信给的地址后返回很多数据,为了方便取值,这里我们也用map集合来接收
        Map<String, String> map = logService.getOrderStatus(no);
        //map不为空,那就从map中获取订单状态
        if (map.get("trade_state").equals("SUCCESS")) {
            //向t_pay_log(支付日志记录表)添加一条记录
            //并且修改t_order(订单表)的status字段为1(已支付)
            if (orderService.updateStatus(map)) {
                // 向日志中添加数据
                logService.insertLog(map);
            }
            return new CommonResult<Map<String, String>>().success().message("支付成功").data(map);
        }
        return new CommonResult<Map<String, String>>().error().code(25000).message("支付中");
    }
}

