package com.ijpay.mapper;

import com.ijpay.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Date;
import java.util.List;


public interface OrderDAO {
    /**
     * 添加订单
     */
    void insertOrder(Order order);

    /**
     * 根据手机号和openid查询订单
     * @param accountphone
     * @param openid
     * @return
     */
    List<Order> selectOrderBy(@Param("accountphone") String accountphone, @Param("openid") String openid);
    void updateOrderByNo(@Param("type") String type, @Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("totalFee") Double totalFee, @Param("state") String state);
    void updateOrderById(@Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("outRefundNo") String outRefundNo, @Param("refundFee") Double refundFee, @Param("state") String state);

    Order selectByNull(String outTradeNo);

    void updateByNo(@Param("orderid") String orderid, @Param("outTradeNo") String outTradeNo);

    void insertOrderBy(@Param("userid") String userid, @Param("openid") String openid, @Param("outTradeNo") String outTradeNo, @Param("state") String state);

    List<Order> selectOrderByState(@Param("openid") String openid, @Param("state") String state);

    List<Order> selectOrderByUserid(@Param("userid") String userid, @Param("state") String state);

}
