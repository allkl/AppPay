package com.ijpay.mapper;

import com.ijpay.entity.Order;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
@Component
public interface OrderMapper {
    /**
     * 添加订单
     */
    @Insert("insert into p_order (orderid,accountphone,openid,productname,unitprice,riginplace,commodityid,imgurl,paid,orderdate,outTradeNo,state) values (#{orderid},#{accountphone},#{openid},#{productname},#{unitprice},#{riginplace},#{commodityid},#{imgurl},#{paid},#{orderdate},#{outTradeNo},#{state})")
    void insertOrder(Order order);

    /**
     * 根据手机号和openid查询订单
     * @param accountphone
     * @param openid
     * @return
     */
    @Select("select productname,unitprice,riginplace,commodityid,imgurl,orderdate from p_order where accountphone = #{accountphone} and openid = #{openid}")
    List<Order> selectOrderBy(@Param("accountphone") String accountphone, @Param("openid") String openid);

    @Update("update p_order set type=#{type},transactionId=#{transactionId},totalFee=#{totalFee},state=#{state} where outTradeNo=#{outTradeNo}")
    void updateOrderByNo(@Param("type") String type, @Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("totalFee") Double totalFee, @Param("state") String state);


    @Update("update p_order set outRefundNo=#{outRefundNo},refundFee=#{refundFee},state=#{state} where outTradeNo=#{outTradeNo} or transactionId=#{transactionId}")
    void updateOrderById(@Param("outTradeNo") String outTradeNo, @Param("transactionId") String transactionId, @Param("outRefundNo") String outRefundNo, @Param("refundFee") Double refundFee, @Param("state") String state);


    @Select("select * from p_order where outTradeNo=#{outTradeNo}")
    Order selectByNull(String outTradeNo);

    @Update("update p_order set outTradeNo=#{outTradeNo} where orderid=#{orderid}")
    void updateByNo(@Param("orderid") String orderid, @Param("outTradeNo") String outTradeNo);

    @Insert("insert into p_order (userid,openid,outTradeNo,state) values (#{userid},#{openid},#{outTradeNo},#{state})")
    void insertOrderBy(@Param("userid") String userid, @Param("openid") String openid, @Param("outTradeNo") String outTradeNo, @Param("state") String state);


    @Select(" select * from p_order where openid=#{openid} and state=#{state}")
    List<Order> selectOrderByState(@Param("openid") String openid, @Param("state") String state);

    @Select(" select * from p_order where userid=#{userid} and state=#{state}")
    List<Order> selectOrderByUserId(@Param("userid") String userid, @Param("state") String state);

}
