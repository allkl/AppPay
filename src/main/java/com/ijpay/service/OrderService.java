package com.ijpay.service;

import com.ijpay.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface OrderService {
    void addOrder(@Param("accountphone") String accountphone, @Param("openid") String openid, @Param("imgurl") String imgurl, @Param("productname") String productname, @Param("unitprice") Double unitprice, @Param("riginplace") String riginplace, @Param("commodityid") String commodityid, @Param("paid") String paid);
    List<Order> queryOrderBy(@Param("accountphone") String accountphone, @Param("openid") String openid);
    void modifyOrderByNo(@Param("type") String type, @Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("totalFee") Double totalFee, @Param("state") String state);
    void modifyOrderById(@Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("outRefundNo") String outRefundNo, @Param("refundFee") Double refundFee, @Param("state") String state);
    Order queryByNull(String outTradeNo);

    void modifyByNo(@Param("orderid") String orderid, @Param("outTradeNo") String outTradeNo);

    void addOrderBy(@Param("userid") String userid, @Param("openid") String openid, @Param("outTradeNo") String outTradeNo, @Param("state") String state);
    List<Order> queryOrderByState(@Param("openid") String openid, @Param("state") String state);

    List<Order> queryOrderByUserid(@Param("userid") String userid, @Param("state") String state);
}
