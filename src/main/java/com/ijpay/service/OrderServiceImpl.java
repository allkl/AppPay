package com.ijpay.service;

import com.ijpay.entity.Order;
import com.ijpay.mapper.OrderMapper;
import com.ijpay.utils.GetString;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service(value = "orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
   @Resource(name = "orderMapper")
    private OrderMapper orderMapper;

   @Autowired
   private Order order;
    /**
     * 预支付添加
     * @param orderid
     * @param deviceInfo
     * @param payType
     * @param openid
     * @param outTradeNo
     * @param totalFee
     * @param tbody
     * @param detail
     * @param attach
     * @param tradeType
     * @param timeStart
     * @param tradeState
     * @param userId
     */
    public void addOrderBy(@Param("orderid")String orderid, @Param("deviceInfo")String deviceInfo, @Param("payType")String payType, @Param("openid")String openid, @Param("outTradeNo")String outTradeNo, @Param("totalFee")Integer totalFee, @Param("tbody")String tbody, @Param("detail")String detail, @Param("attach")String attach, @Param("tradeType")String tradeType, @Param("timeStart")Date timeStart, @Param("tradeState")String tradeState, @Param("userId")String userId){
        order.setOrderid(orderid);
        order.setDeviceInfo(deviceInfo);
        order.setPayType(payType);
        order.setOpenid(openid);
        order.setOutTradeNo(outTradeNo);
        order.setTotalFee(totalFee);
        order.setTbody(tbody);
        order.setDetail(detail);
        order.setAttach(attach);
        order.setTradeType(tradeType);
        order.setTimeStart(timeStart);
        order.setTradeState(tradeState);
        order.setUserId(userId);
        orderMapper.insertOrderBy(order);
    }

    /**
     * 支付完成后修改
     * @param outTradeNo
     * @param transactionId
     * @param fee
     * @param timeExpire
     * @param tradeState
     */
    public void modifyOrderByNo( @Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("fee") Float fee,@Param("timeExpire") Date timeExpire, @Param("tradeState") String tradeState){
        orderMapper.updateOrderByNo(outTradeNo,transactionId,fee,timeExpire,tradeState);
    }



    public void modifyOrderById(@Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("outRefundNo") String outRefundNo, @Param("refundFee") Float refundFee, @Param("tradeState") String tradeState,@Param("refundSuccessTime") Date refundSuccessTime){
        orderMapper.updateOrderById(outTradeNo,transactionId,outRefundNo,refundFee,tradeState,refundSuccessTime);
    }


    public Order queryByOutTradeNo(String outTradeNo){
        return orderMapper.selectByOutTradeNo(outTradeNo);
    }


    public void modifyByNo(@Param("orderid") String orderid, @Param("outTradeNo") String outTradeNo){
        orderMapper.updateByNo(orderid,outTradeNo);
    }


    /**
     * 通过openid和支付状态查询相应的订单
     * @param openid
     * @param tradeState
     * @return
     */
    public List<Order> queryOrderByOpenid(@Param("openid") String openid, @Param("tradeState") String tradeState){
        return orderMapper.selectOrderByOpenid(openid,tradeState);
    }

    /**
     * 通过id和支付状态查询相应的订单
     * @param userId
     * @param tradeState
     * @return
     */
    public List<Order> queryOrderByUserId(@Param("userId") String userId, @Param("tradeState") String tradeState){
       return orderMapper.selectOrderByUserId(userId, tradeState);
    }
}
