package com.example.terrissedu.service;

import com.example.terrissedu.entity.StudentMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.terrissedu.entity.vo.MemberVO;
import com.example.terrissedu.utils.CommonResult;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
public interface StudentMemberService extends IService<StudentMember> {

    CommonResult<String> login(MemberVO member);

    CommonResult<Boolean> register(MemberVO member);

    CommonResult<StudentMember> getMemberByToken(HttpServletRequest request);

    StudentMember saveIfNotExisted(String nickname, String avatar, String openid, Integer sex);

    Integer countDailyRegisters(String date);
}
