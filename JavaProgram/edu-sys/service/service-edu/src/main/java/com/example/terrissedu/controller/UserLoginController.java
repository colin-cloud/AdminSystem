package com.example.terrissedu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.entity.AuthUser;
import com.example.terrissedu.entity.dto.UserDTO;
import com.example.terrissedu.service.AuthUserService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.ResultMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Terriss
 * @time 2023-06-29 20:14:49
 * @description 登录后端接口
 */
@Api(tags = "登录管理")
@RestController
@RequestMapping("/edu-service/user")
@CrossOrigin// 解决跨域问题
public class UserLoginController {

    @Autowired
    private AuthUserService userService;

    @PostMapping("/login")
    @ApiOperation("系统登录")
    public CommonResult<UserDTO> login(@RequestBody UserDTO user) {
        CommonResult<UserDTO> res = new CommonResult<>();
//        QueryWrapper<AuthUser> wrapper = new QueryWrapper<>();
//        wrapper.eq("username", user.getUsername());
//        wrapper.eq("password", user.getPassword());
//        AuthUser authUser = userService.getOne(wrapper);
//        if (authUser == null) {
//            res.error(ResultMessage.USER_LOGIN_ERROR);
//        } else {
//            user.setToken("admin");
//            res.success(ResultMessage.USER_LOGIN_SUCCESS, user);
//        }
        user.setToken("admin");
        res.success("成功", user);
        return res;
    }

    @GetMapping("/info")
    public CommonResult<UserDTO> info(String token) {
        CommonResult<UserDTO> res = new CommonResult<>();
        UserDTO userDTO = new UserDTO("admin", "admin");
        userDTO.setName("admin");
        userDTO.setAvatar("https://image.baidu.com/search/detail?ct=503316480&z=0&tn=baiduimagedetail&ipn=d&cl=2&cm=1&sc=0&lm=-1&ie=gb18030&pn=0&rn=1&di=7214885350303334401&ln=30&word=%CD%B7%CF%F1&os=2685334553,84983097&cs=1370340984,172948404&objurl=http%3A%2F%2Fsafe-img.xhscdn.com%2Fbw1%2Fae175b96-62b4-4c48-ae36-a278a8a27e2c%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&bdtype=0&simid=1370340984,172948404&pi=0&adpicid=0&timingneed=&spn=0&is=2685334553,84983097&fr=ala&ala=1&alatpl=normal&pos=1&oriquery=%E5%A4%B4%E5%83%8F&dyTabStr=MCw2LDMsMSw0LDUsMiw4LDcsOQ%3D%3D");
        res.success("陈工", userDTO);
        return res;
    }
}
