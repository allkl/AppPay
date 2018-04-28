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
    @Override
    public void addOrder(@Param("accountphone") String accountphone, @Param("openid") String openid, @Param("imgurl") String imgurl, @Param("productname") String productname, @Param("unitprice") Double unitprice, @Param("riginplace") String riginplace, @Param("commodityid") String commodityid, @Param("paid") String paid) {
        Order order = new Order();
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        order.setOrderid(uuid);
        order.setAccountphone(accountphone);
        order.setOpenid(openid);
        order.setOrderdate(new Date());
        order.setOutTradeNo(GetString.getRandomStringByLength(32).replaceAll("-",""));
        order.setState("0");
        orderMapper.insertOrder(order);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Order> queryOrderBy(@Param("accountphone") String accountphone, @Param("openid") String openid) {
        return orderMapper.selectOrderBy(accountphone,openid);
    }

    @Override
    public void modifyOrderByNo(String type,String outTradeNo, String transactionId, Double totalFee, String state) {
        orderMapper.updateOrderByNo(type,outTradeNo,transactionId,totalFee,state);
    }

    @Override
    public void modifyOrderById(@Param("outTradeNo") String outTradeNo, @Param("transactionId")String transactionId, @Param("outRefundNo") String outRefundNo, @Param("refundFee")Double refundFee, @Param("state")String state){
        orderMapper.updateOrderById(outTradeNo,transactionId,outRefundNo,refundFee,state);
    }

    public Order queryByNull(String outTradeNo){
       return orderMapper.selectByNull(outTradeNo);
    }

    public void modifyByNo(@Param("orderid") String orderid, @Param("outTradeNo")String outTradeNo){
        orderMapper.updateByNo(orderid,outTradeNo);

    }

    public void addOrderBy(@Param("userid")String userid, @Param("openid") String openid, @Param("outTradeNo")String outTradeNo, @Param("state") String state){
        orderMapper.insertOrderBy(userid,openid,outTradeNo,state);
    }

    @Override
    public List<Order> queryOrderByState(@Param("openid") String openid, @Param("state") String state) {
        return orderMapper.selectOrderByState(openid+"", state);
    }

    @Override
    public List<Order> queryOrderByUserid(@Param("userid") String userid, @Param("state") String state) {
        return orderMapper.selectOrderByUserId(userid,state);
    }
}
