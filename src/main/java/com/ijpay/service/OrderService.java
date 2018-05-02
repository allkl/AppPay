package com.ijpay.service;

import com.ijpay.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;


public interface OrderService {
    /**
     * 预支付添加
     * @param orderid
     * @param deviceInfo
     * @param payType
     * @param openid
     * @param outTradeNo
     * @param fee
     * @param tbody
     * @param detail
     * @param attach
     * @param tradeType
     * @param timeStart
     * @param tradeState
     * @param userId
     */
    void addOrderBy(@Param("orderid")String orderid, @Param("deviceInfo")String deviceInfo, @Param("payType")String payType, @Param("openid")String openid, @Param("outTradeNo")String outTradeNo, @Param("fee")Float fee, @Param("tbody")String tbody, @Param("detail")String detail, @Param("attach")String attach, @Param("tradeType")String tradeType, @Param("timeStart")Date timeStart, @Param("tradeState")String tradeState, @Param("userId")String userId);

    /**
     * 支付完成后修改
     * @param outTradeNo
     * @param transactionId
     * @param fee
     * @param timeExpire
     * @param tradeState
     */
    void modifyOrderByNo( @Param("openid")String openid,@Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("fee") Float fee,@Param("timeExpire") Date timeExpire, @Param("tradeState") String tradeState);



    void modifyOrderById(@Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("outRefundNo") String outRefundNo, @Param("refundFee") Float refundFee, @Param("tradeState") String tradeState,@Param("refundSuccessTime") Date refundSuccessTime);


    Order queryByOutTradeNo(String outTradeNo);


    void modifyByNo(@Param("orderid") String orderid, @Param("outTradeNo") String outTradeNo);


    /**
     * 通过openid和支付状态查询相应的订单
     * @param openid
     * @param tradeState
     * @return
     */
    List<Order> queryOrderByOpenid(@Param("openid") String openid, @Param("tradeState") String tradeState);


    List<Order> queryOrderByOpenidAll(String openid);

    /**
     * 通过id和支付状态查询相应的订单
     * @param userId
     * @param tradeState
     * @return
     */
    List<Order> queryOrderByUserId(@Param("userId") String userId, @Param("tradeState") String tradeState,@Param("payType")String payType);

    List<Order> queryOrderByUserIdAll(@Param("userId") String userId,@Param("payType")String payType);
}
