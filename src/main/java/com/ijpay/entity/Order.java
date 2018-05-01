package com.ijpay.entity;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * `orderid` varchar(32) default NULL,//订单号
 `payType` varchar(32) default NULL,//支付方式
 `openid` varchar(32) default NULL,//用户标识
 `outTradeNo` varchar(32) default NULL,//商户订单号
 `totalFee` int(11) default NULL,//支付金额
 `feeType` varchar(32) default NULL,//货币类型
 `tbody` varchar(128) default NULL,//商品描述
 `detail` varchar(128) default NULL,//商品详情
 `attach` varchar(128) default NULL,//附加数据
 `tradeType` varchar(32) default NULL,//交易类型
 `timeStart` datetime default NULL,//订单开始时间
 `tradeState` varchar(1) default NULL,//交易状态
 `transactionId` varchar(32) default NULL,//微信支付订单号
 `fee` float default NULL,//付款金额
 `timeExpire` datetime default NULL,//支付完成时间
 `outRefundNo` varchar(32) default NULL,//退款商户订单号
 `refundFee` float default NULL,//退款金额
 `refundId` varchar(32) default NULL,//微信退款订单号
 `refundSuccessTime` datetime default NULL,//退款完成时间
 `userId` varchar(32) default NULL//用户id
 */
@Component
public class Order {
    private String orderid;//订单号
    private String deviceInfo;//设备号
    private String payType;//支付方式
    private String openid;//用户标识
    private String outTradeNo;//商户订单号
    private Integer totalFee;//支付金额
    private String feeType;//货币类型
    private String tbody;//商品描述
    private String detail;//商品详情
    private String attach;//附加数据
    private String tradeType;//交易类型
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date timeStart;//订单开始时间
    private String tradeState;//交易状态
    private String transactionId;//微信支付订单号
    private Float fee;//付款金额
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date timeExpire;//支付完成时间
    private String outRefundNo;//退款商户订单号
    private Float refundFee;//退款金额
    private String refundId;//微信退款订单号
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date refundSuccessTime;//退款完成时间
    private String userId;//用户id

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getTbody() {
        return tbody;
    }

    public void setTbody(String tbody) {
        this.tbody = tbody;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public String getTradeState() {
        return tradeState;
    }

    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

    public Date getTimeExpire() {
        return timeExpire;
    }

    public void setTimeExpire(Date timeExpire) {
        this.timeExpire = timeExpire;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public Float getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(Float refundFee) {
        this.refundFee = refundFee;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    public Date getRefundSuccessTime() {
        return refundSuccessTime;
    }

    public void setRefundSuccessTime(Date refundSuccessTime) {
        this.refundSuccessTime = refundSuccessTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", payType='" + payType + '\'' +
                ", openid='" + openid + '\'' +
                ", outTradeNo='" + outTradeNo + '\'' +
                ", totalFee=" + totalFee +
                ", feeType='" + feeType + '\'' +
                ", tbody='" + tbody + '\'' +
                ", detail='" + detail + '\'' +
                ", attach='" + attach + '\'' +
                ", tradeType='" + tradeType + '\'' +
                ", timeStart=" + timeStart +
                ", tradeState='" + tradeState + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", fee=" + fee +
                ", timeExpire=" + timeExpire +
                ", outRefundNo='" + outRefundNo + '\'' +
                ", refundFee=" + refundFee +
                ", refundId='" + refundId + '\'' +
                ", refundSuccessTime=" + refundSuccessTime +
                ", userId='" + userId + '\'' +
                '}';
    }
}
