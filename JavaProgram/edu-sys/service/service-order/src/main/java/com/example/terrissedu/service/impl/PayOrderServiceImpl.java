package com.example.terrissedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.client.EduCourseClient;
import com.example.terrissedu.client.StudentMemberClient;
import com.example.terrissedu.entity.PayOrder;
import com.example.terrissedu.mapper.PayOrderMapper;
import com.example.terrissedu.service.PayOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.terrissedu.utils.CommonResult;
import com.example.terrissedu.utils.JWTUtil;
import com.example.terrissedu.utils.OrderNoUtil;
import com.example.terrissedu.utils.ResultMessage;
import com.example.terrissedu.utils.dto.CourseDTO;
import com.example.terrissedu.utils.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Service
public class PayOrderServiceImpl extends ServiceImpl<PayOrderMapper, PayOrder>
        implements PayOrderService {

    @Autowired
    private EduCourseClient courseClient;

    @Autowired
    private StudentMemberClient memberClient;

    @Override
    public CommonResult<String> createOrder(Long courseId, HttpServletRequest request) {
        CommonResult<String> res = new CommonResult<>();

        // 通过课程id获取课程信息
        CourseDTO course = courseClient.getCourseByCourseId(courseId);

        // 获取用户信息 -- 获取用户id
        String userId = JWTUtil.getMemberIdByJwtToken(request);

        // 通过userId获取用户信息
        MemberDTO member = memberClient.getMemberById(userId);

        // 获取随机订单号
        String orderNo = OrderNoUtil.getOrderNo();

        // 创建订单
        PayOrder order = new PayOrder();

        order.setCourseId(course.getId());
        order.setCourseCover(course.getCover());
        order.setCourseTitle(course.getTitle());
        order.setTeacherName(course.getTeacherName());
        order.setTotalFee(course.getPrice());
        order.setMemberId(member.getId());
        order.setMobile(member.getMobile());
        order.setNickname(member.getNickname());
        order.setOrderNo(orderNo);

        save(order);

        return res.success()
                .message(ResultMessage.SELECT_ORDER_SUCCESS)
                .data(orderNo);
    }

    @Override
    public PayOrder getOrderByNo(String no) {
        QueryWrapper<PayOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("order_no", no);
        return getOne(wrapper);
    }

    @Override
    public boolean updateStatus(Map<String, String> map) {
        //1.获取订单号
        String orderNo = map.get("out_trade_no");
        PayOrder order = getOrderByNo(orderNo);
        if (order.getStatus() == 1) return false;
        order.setStatus(1);
        return update(order, null);
    }
}
