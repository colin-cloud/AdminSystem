package com.example.terrissedu.controller;

import com.example.terrissedu.entity.StudentMember;
import com.example.terrissedu.exception.CustomException;
import com.example.terrissedu.service.StudentMemberService;
import com.example.terrissedu.utils.HttpClientUtils;
import com.example.terrissedu.utils.JWTUtil;
import com.example.terrissedu.utils.ResultCode;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @author Terriss
 * @time 2023-07-07 14:03:17
 * @description TODO
 */

@Controller
@RequestMapping("/api/ucenter/wx")
@CrossOrigin
@Api(tags = "微信管理")
public class WXApiController {

    @Value("${wx.open.app-id}")
    private String appId;

    @Value("${wx.open.app-secret}")
    private String appSecret;

    @Value("${wx.open.redirect-url}")
    private String redirectUrl;

    @Autowired
    private StudentMemberService memberService;

    @GetMapping("/callback")
    public String callback(String code, String state) {
        // 用code请求微信固定地址，得到access_token和openid
        String baseAccessTokenUrl =
                "https://api.weixin.qq.com/sns/oauth2/access_token" +
                "?appid=%s" +
                "&secret=%s" +
                "&code=%s" +
                "&grant_type=authorization_code";
        // 拼接参数
        String tokenUrl = String.format(
                baseAccessTokenUrl,
                appId,
                appSecret,
                code
                );
        // 请求地址 -- httpclient
        try {
            String accessTokenInfo = HttpClientUtils.get(tokenUrl);

            //从accessTokenInfo获取access_token和openid
            Gson gson = new Gson();
            HashMap map = gson.fromJson(accessTokenInfo, HashMap.class);
            String accessToken = (String)map.get("access_token");
            String openid = (String)map.get("openid");

            // 通过access_token和openid访问地址
            String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" +
                    "?access_token=%s" +
                    "&openid=%s";

            // 拼接参数
            String userInfoUrl = String.format(
                    baseUserInfoUrl,
                    accessToken,
                    openid
            );

            // 发送请求
            String userInfo = HttpClientUtils.get(userInfoUrl);
            // 转换成map
            HashMap user = gson.fromJson(userInfo, HashMap.class);
            // 获取信息
            String nickname = (String)user.get("nickname"), avatar = (String)user.get("headimgurl");

            // 添加进数据库中
            // 判断是否存在该openid
            StudentMember member = memberService.saveIfNotExisted(nickname, avatar, openid, 2);

            // 使用jwt生成token字符串，并传递给前端
            String token = JWTUtil.getJwtToken(member.getId() + "", member.getNickname());

            return "redirect:http://localhost:3000?token=" + token;

        } catch (Exception e) {
            throw new CustomException(ResultCode.ERROR, "请求异常");
        }
    }

    @GetMapping("/getWXCode")
    public String getWXCode() {
        //1.url中的%s就相当于问号(?),代表占位符
        String baseUrl =
                "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s" +
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";
        //2.对redirect_url进行URLEncode编码
        String redirect_url = redirectUrl;
        try {
            redirect_url = URLEncoder.encode(redirect_url, "utf-8");
        } catch(Exception e) {
            e.printStackTrace();
        }
        //3.给baseUrl中的占位符(%s)赋值
        String url = String.format(
                baseUrl,
                appId,
                redirect_url,
                "terriss"
        ); //方法的返回值就是完整的带有参数的url地址
        //4.重定向到请求微信地址里面
        return "redirect:" + url;
    }
}
