package com.ijpay.controller.wxpay;

import com.jpay.weixin.api.WxPayApiConfig;

public abstract class WxPayApiController{
	public abstract WxPayApiConfig getApiConfig();
	//小程序配置
	public abstract WxPayApiConfig getWxApiConfig();
}