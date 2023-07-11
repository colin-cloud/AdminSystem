package com.example.terrissedu.controller;


import com.example.terrissedu.entity.StudentMember;
import com.example.terrissedu.entity.vo.MemberVO;
import com.example.terrissedu.service.StudentMemberService;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.dto.MemberDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Api(tags = "用户中心")
@RestController
@RequestMapping("/user-service/student-member")
@CrossOrigin
public class StudentMemberController {

    @Autowired
    private StudentMemberService memberService;

    @GetMapping("/countDailyUsers")
    @ApiOperation("网站一天的访问量")
    public CommonResult<Long> countDailyUsers() {
        return new CommonResult<Long>().success().message("查询一天用户量").data(1L);
    }

    @GetMapping("/countDailyRegisters/{date}")
    @ApiOperation("网站一天的注册量")
    public CommonResult<Integer> countDailyRegisters(@PathVariable("date") String date) {
        Integer res = memberService.countDailyRegisters(date);
        return new CommonResult<Integer>().success().message("查询一天的注册量").data(res);
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    public CommonResult<String> login(@RequestBody MemberVO member) {
        return memberService.login(member);
    }

    @ApiOperation("用户注册")
    @PostMapping("/register")
    public CommonResult<Boolean> register(@RequestBody MemberVO member) {
        return memberService.register(member);
    }

    @ApiOperation("根据token获取用户信息")
    @GetMapping("/getMemberByToken")
    public CommonResult<StudentMember> getMemberByToken(HttpServletRequest request) {
        return memberService.getMemberByToken(request);
    }

    @ApiOperation("根据token获取用户信息")
    @GetMapping("/getMemberById/{id}")
    public MemberDTO getMemberById(@PathVariable("id") String id) {
        StudentMember member = memberService.getById(id);
        MemberDTO res = new MemberDTO();
        BeanUtils.copyProperties(member, res);
        return res;
    }
}

