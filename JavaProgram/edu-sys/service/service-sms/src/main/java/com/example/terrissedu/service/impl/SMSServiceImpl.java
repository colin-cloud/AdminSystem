package com.example.terrissedu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.example.terrissedu.service.SMSService;
import com.example.terrissedu.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
/**
 * @author Terriss
 * @time 2023-07-06 14:18:30
 * @description TODO
 */
@Service
public class SMSServiceImpl implements SMSService {


    @Value("${aliyun.oss.file.keyid}")
    private String keyId;

    @Value("${aliyun.oss.file.keysecret}")
    private String keySecret;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean sendMessage(String phone) {
        // 先从redis中获取
        String code = redisTemplate.opsForValue().get("PhoneMessageCode:" + phone);
        // 判断是否为空
        if (StringUtils.isEmpty(code)) {
            code = RandomUtil.getCode();
        } else {
            return true;
        }
        if(StringUtils.isEmpty(phone)) return false;

        DefaultProfile profile = DefaultProfile.getProfile(
                "default", keyId, keySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        //设置相关参数(固定的,不需要修改)
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST); //提交方式
        request.setDomain("dysmsapi.aliyuncs.com"); //发送时要访问阿里云中的哪个地方
        request.setVersion("2017-05-25"); //版本号
        request.setAction("SendSms"); //请求里面的哪个方法

        //设置发送的相关参数
        request.putQueryParameter("PhoneNumbers", phone); //设置要发送的手机号
        request.putQueryParameter("SignName", "阿里云短信测试"); //在阿里云申请的签名名称
        request.putQueryParameter("TemplateCode", "SMS_154950909"); //在阿里云中申请的模板Code
        HashMap<String, String> map = new HashMap<>();
        map.put("code", code);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(map)); //验证码数据
        boolean success = false;
        try {
            //最终发送
            CommonResponse response = client.getCommonResponse(request);

            success = response.getHttpResponse().isSuccess();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }

        if (success) {
            // 将当前code放入到redis中,并设置有效时间
            redisTemplate.opsForValue().set("PhoneMessageCode:" + phone, code, 5, TimeUnit.MINUTES);
        }
        return success;
    }
}
