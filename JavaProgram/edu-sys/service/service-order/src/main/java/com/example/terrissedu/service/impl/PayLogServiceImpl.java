package com.example.terrissedu.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.terrissedu.entity.PayLog;
import com.example.terrissedu.entity.PayOrder;
import com.example.terrissedu.exception.CustomException;
import com.example.terrissedu.mapper.PayLogMapper;
import com.example.terrissedu.service.PayLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.terrissedu.service.PayOrderService;
import com.example.terrissedu.utils.HttpClient;
import com.example.terrissedu.utils.ResultCode;
import com.example.terrissedu.utils.ResultMessage;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Payload;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author terriss
 * @since 2023-06-28
 */
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

    @Autowired
    private PayOrderService orderService;

    @Override
    public Map<String, String> createWXCode(String orderNo) {

        //1. 根据订单号获取订单信息
        PayOrder order = orderService.getOrderByNo(orderNo);

        //2.使用map集合设置生成二维码需要的参数
        Map<String, String> m = new HashMap<>();
        m.put("appid", "wx74862e0dfcf69954"); //支付id
        m.put("mch_id", "1558950191"); //商户号
        m.put("nonce_str", WXPayUtil.generateNonceStr()); //生成随机唯一字符串,使得生成的每个二维码都不同
        m.put("body", order.getCourseTitle()); //生成的二维码显示什么名字
        m.put("out_trade_no", orderNo); //二维码的唯一标识,我们的订单号都是唯一的,所以一般赋值订单号
        m.put("total_fee", order.getTotalFee().multiply(new BigDecimal("100")).longValue()+""); //扫码的价格
        m.put("spbill_create_ip", "127.0.0.1"); //支付服务的ip地址(域名也行),我们这里是本地,所以赋值127.0.0.1
        m.put("notify_url", "http://guli.shop/api/order/weixinPay/weixinNotify\n");//支付后回调的地址,老师说目前用不到
        m.put("trade_type", "NATIVE"); //支付类型,NATIVE就表示根据价格生成一个支付二维码

        try {
            //3.发送httpclient请求,请求的参数是xml格式
            //3.1设置请求地址(请求地址是微信给的固定的)
            HttpClient client = new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
            //3.2设置请求参数(xml格式)
            // generateSignedXml方法作用:根据商户key对map集合做加密并将加密后的map集合转为xml格式
            // setXmlParam方法作用:将得到的xml格式字符串设置为请求参数
            client.setXmlParam(WXPayUtil.generateSignedXml(m, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));
            //3.3因为请求的地址是https的,默认无法请求,有了下面这行代码就可以请求了
            client.setHttps(true);
            //3.4执行发送请求(发送xml格式参数的请求)
            client.post();

            //4.获取请求返回的数据
            //4.1获取数据
            String xml = client.getContent();
            //4.2将xml数据转为map集合
            //发送请求后微信返回的内容是xml格式字符串,为了方便前端取值,我们把xml格式转换为map集合,把这个map集合返回给控制层
            Map<String, String> resultMap = WXPayUtil.xmlToMap(xml);

            System.out.println(resultMap);
            //5.最终返回数据的封装
            //但此时我们需要的其它数据并没有在resultMap集合中(如:订单号、课程id...),需要我们手动封装
            Map<String, String> map = new HashMap<>();
            map.put("out_trade_no", orderNo); //订单号
            map.put("course_id", order.getCourseId() + ""); //课程id
            map.put("total_fee", order.getTotalFee().multiply(new BigDecimal("100")).longValue()+""); //订单金额
            map.put("result_code", resultMap.get("result_code")); //二维码操作状态码
            map.put("code_url", resultMap.get("code_url")); //二维码地址

            return map;
        } catch (Exception e) {
            throw new CustomException(ResultCode.ERROR, ResultMessage.CREATE_CODE_ERROR);
        }
    }

    @Override
    public Map<String, String> getOrderStatus(String no) {
        try {
            //1.封装参数
            Map<String, String> m = new HashMap<>();
            m.put("appid", "wx74862e0dfcf69954");
            m.put("mch_id", "1558950191");
            m.put("out_trade_no", no);
            m.put("nonce_str", WXPayUtil.generateNonceStr());

            //2.发送httpclient请求
            HttpClient client = new HttpClient(
                    "https://api.mch.weixin.qq.com/pay/orderquery");
            client.setXmlParam(WXPayUtil.generateSignedXml(
                    m, "T6m9iK73b0kn9g5v426MKfHQH7X8rKwb"));
            client.setHttps(true);
            client.post();

            //3.获取微信返回的数据,并将xml格式数据转为map集合
            String xml = client.getContent();

            return WXPayUtil.xmlToMap(xml);
        } catch (Exception e) {
            throw new CustomException(ResultCode.ERROR, ResultMessage.QUERY_STATUS_SUCCESS);
        }
    }

    @Override
    public boolean insertLog(Map<String, String> map) {
        //1.获取订单号
        String orderNo = map.get("out_trade_no");
        // 2. 创建日志
        PayLog log = new PayLog();
        // 获取订单
        PayOrder order = orderService.getOrderByNo(orderNo);

        log.setAttr(JSONObject.toJSONString(map));
        log.setOrderNo(orderNo);
        log.setPayTime(new Date());
        log.setTotalFee(order.getTotalFee());
        log.setTradeState(map.get("trade_state"));
        log.setTransactionId(map.get("transaction_id"));

        return save(log);
    }

    @Override
    public boolean isBoughtOneCourse(Long memberId, Long courseId) {
        // 查询是否存在订单
        QueryWrapper<PayOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("member_id", memberId)
                .eq("course_id", courseId);
        PayOrder order = orderService.getOne(wrapper);
        if (order == null) {
            return false;
        } else {
            // 获取订单号
            String orderNo = order.getOrderNo();
            // 查询是否存在支付日志
            QueryWrapper<PayLog> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("order_no", orderNo);
            PayLog log = getOne(queryWrapper);
            return log != null;
        }
    }
}
