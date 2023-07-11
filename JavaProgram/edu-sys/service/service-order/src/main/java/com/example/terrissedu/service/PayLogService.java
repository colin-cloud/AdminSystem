package com.example.terrissedu.service;

import com.example.terrissedu.entity.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 支付日志表 服务类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
public interface PayLogService extends IService<PayLog> {

    Map<String, String> createWXCode(String orderNo);

    Map<String, String> getOrderStatus(String no);

    boolean insertLog(Map<String, String> map);

    boolean isBoughtOneCourse(Long memberId, Long courseId);
}
