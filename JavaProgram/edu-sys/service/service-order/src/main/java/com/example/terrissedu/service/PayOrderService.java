package com.example.terrissedu.service;

import com.example.terrissedu.entity.PayOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.terrissedu.utils.CommonResult;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
public interface PayOrderService extends IService<PayOrder> {

    CommonResult<String> createOrder(Long courseId, HttpServletRequest request);

    PayOrder getOrderByNo(String no);

    boolean updateStatus(Map<String, String> map);
}
