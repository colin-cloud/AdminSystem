package com.example.terrissedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.terrissedu.entity.StudentMember;
import com.example.terrissedu.entity.vo.MemberVO;
import com.example.terrissedu.exception.CustomException;
import com.example.terrissedu.mapper.StudentMemberMapper;
import com.example.terrissedu.service.StudentMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.terrissedu.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Service
public class StudentMemberServiceImpl extends ServiceImpl<StudentMemberMapper, StudentMember>
        implements StudentMemberService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StudentMemberMapper memberMapper;

    @Override
    public CommonResult<String> login(MemberVO member) {
        CommonResult<String> result = new CommonResult<>();

        if (StringUtils.isEmpty(member.getMobile()) || StringUtils.isEmpty(member.getPassword())) {
            throw new CustomException(ResultCode.ERROR, "用户不存在");
        }

        QueryWrapper<StudentMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", member.getMobile())
                .eq("is_enable", 1);

        StudentMember res = getOne(wrapper);

        if (res == null) {
            throw new CustomException(ResultCode.ERROR, "用户不存在");
        }
        String md5 = MD5Util.encrypt(member.getPassword());
        if (md5.equals(res.getPassword())) {
            // 成功，返回一个token
            String token = JWTUtil.getJwtToken(res.getId() + "", res.getNickname());
            result.success(ResultMessage.USER_LOGIN_SUCCESS, token);
        } else {
            result.error(ResultMessage.USER_LOGIN_ERROR);
        }

        return result;
    }

    @Override
    public CommonResult<Boolean> register(MemberVO member) {
        CommonResult<Boolean> result = new CommonResult<>();

        String phone = member.getMobile(), password = member.getPassword(),
                nickname = member.getNickname();
        // 从数据库中查询是否存在该用户
        QueryWrapper<StudentMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", phone)
                .eq("is_enable", 1);

        StudentMember res = getOne(wrapper);

        if (res != null) {
            result.error(ResultMessage.USER_EXIT_ERROR);
        } else {
            //验证码校验
            String key = "PhoneMessageCode:" + phone;
            String phoneCode = redisTemplate.opsForValue().get(key);
            if (!member.getCode().equals(phoneCode)) {
                result.error(ResultMessage.CODE_VERIFY_ERROR);
            } else {
                // 向数据库中添加数据
                res = new StudentMember(phone, MD5Util.encrypt(password), nickname);
                boolean save = save(res);
                if (save) {
                    result.success(ResultMessage.USER_REGISTER_SUCCESS, true);
                } else {
                    result.error(ResultMessage.USER_REGISTER_ERROR);
                }
            }
        }
        // 返回数据
        return result;
    }

    @Override
    public CommonResult<StudentMember> getMemberByToken(HttpServletRequest request) {

        CommonResult<StudentMember> result = new CommonResult<>();

        String id = JWTUtil.getMemberIdByJwtToken(request);
        if (!StringUtils.hasLength(id)) {
            result.error(ResultMessage.TOKEN_EXPIRE);
        } else {
            // 从数据库中查询数据
            StudentMember res = getById(id);
            if (res == null) {
                result.error(ResultMessage.TOKEN_EXPIRE);
            } else {
                result.success(ResultMessage.GET_USER_SUCCESS, res);
            }
        }
        return result;
    }

    @Override
    public StudentMember saveIfNotExisted(String nickname, String avatar, String openid, Integer sex) {
        QueryWrapper<StudentMember> wrapper = new QueryWrapper<>();

        wrapper.eq("openId", openid);
        StudentMember member = getOne(wrapper);

        if (member == null) {
            // 添加
            member = new StudentMember(nickname, avatar, openid, sex);
        }
        member.setNickname(nickname);
        member.setSex(sex);
        member.setAvatar(avatar);

        saveOrUpdate(member);

        return member;
    }

    @Override
    public Integer countDailyRegisters(String date) {
        return memberMapper.countDailyRegisters(date);
    }
}
