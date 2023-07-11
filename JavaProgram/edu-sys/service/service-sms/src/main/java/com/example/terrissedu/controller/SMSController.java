package com.example.terrissedu.controller;

import com.example.terrissedu.service.SMSService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Terriss
 * @time 2023-07-06 14:16:34
 * @description TODO
 */
@RestController
@CrossOrigin
@RequestMapping("/sms-service/edu-sms")
@Api(tags = "短信管理")
public class SMSController {

    @Autowired
    private SMSService smsService;

    @GetMapping("/sendMessage/{phone}")
    public CommonResult<Boolean> sendMessage(@PathVariable("phone") String phone) {
        CommonResult<Boolean> res = new CommonResult<>();
        boolean flag = smsService.sendMessage(phone);
        if (flag) {
            res.success(ResultMessage.SEND_MESSAGE_SUCCESS, true);
        } else {
            res.error(ResultMessage.SEND_MESSAGE_ERROR);
        }
        return res;
    }
}
