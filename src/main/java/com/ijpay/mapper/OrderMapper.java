package com.ijpay.mapper;

import com.ijpay.entity.Order;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Date;
import java.util.List;

@Mapper
@Component
public interface OrderMapper {
    /**
     * 预支付添加
     */
    @Insert("insert into p_order (orderid,deviceInfo,payType,openid,outTradeNo,fee,tbody,detail,attach,tradeType,timeStart,tradeState,userId) values (#{orderid},#{deviceInfo},#{payType},#{openid},#{outTradeNo},#{fee},#{tbody},#{detail},#{attach},#{tradeType},#{timeStart},#{tradeState},#{userId})")
    void insertOrderBy(Order order);

    /**
     * 支付完成后修改
     * @param outTradeNo
     * @param transactionId
     * @param timeExpire
     * @param tradeState
     */
    @Update("update p_order set openid=#{openid},transactionId=#{transactionId},fee=#{fee},timeExpire=#{timeExpire},tradeState=#{tradeState} where outTradeNo=#{outTradeNo}")
    void updateOrderByNo(@Param("openid")String openid, @Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("fee") Float fee,@Param("timeExpire") Date timeExpire, @Param("tradeState") String tradeState);


    @Update("update p_order set outRefundNo=#{outRefundNo},refundFee=#{refundFee},tradeState=#{tradeState},refundSuccessTime=#{refundSuccessTime} where outTradeNo=#{outTradeNo} or transactionId=#{transactionId}")
    void updateOrderById(@Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("outRefundNo") String outRefundNo, @Param("refundFee") Float refundFee,@Param("tradeState") String tradeState,@Param("refundSuccessTime") Date refundSuccessTime);


    @Select("select * from p_order where outTradeNo=#{outTradeNo}")
    Order selectByOutTradeNo(String outTradeNo);



    @Update("update p_order set outTradeNo=#{outTradeNo} where orderid=#{orderid}")
    void updateByNo(@Param("orderid") String orderid, @Param("outTradeNo") String outTradeNo);


    /**
     * 通过openid和支付状态查询相应的订单
     * @param openid
     * @param tradeState
     * @return
     */
    @Select(" select * from p_order where openid=#{openid} and tradeState = #{tradeState}")
    List<Order> selectOrderByOpenid(@Param("openid") String openid, @Param("tradeState") String tradeState);

    @Select(" select * from (select * from p_order where openid=#{openid})t1 where tradeState in (0,1,2)")
    List<Order> selectOrderByOpenidAll(String openid);

    /**
     * 通过id和支付状态查询相应的订单
     * @param userId
     * @param tradeState
     * @return
     */
    @Select(" select * from p_order where userId=#{userId} and tradeState=#{tradeState} and payType=#{payType}")
    List<Order> selectOrderByUserId(@Param("userId") String userId, @Param("tradeState") String tradeState,@Param("payType")String payType);


    @Select(" select * from (select * from p_order where userId=#{userId} and payType=#{payType})t1 where tradeState in (0,1,2)")
    List<Order> selectOrderByUserIdAll(@Param("userId") String userId,@Param("payType")String payType);

}
