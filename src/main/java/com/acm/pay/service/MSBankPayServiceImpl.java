package com.acm.pay.service;

import com.acm.pay.apis.MSBankPayService;
import com.acm.pay.constants.MSBankConstants;
import com.acm.pay.enums.MSPayType;
import com.acm.pay.https.HttpClientUtil;
import com.acm.pay.pojo.TradeReq;
import com.acm.pay.pojo.TradeRes;
import com.alibaba.fastjson.JSON;

public class MSBankPayServiceImpl implements MSBankPayService {

	public TradeRes unionPay(TradeReq req) throws Exception {
		if(req.getSelectTradeType().equals(MSPayType.H5_WXJSAPI.getType())) {
			
		}else if (req.getSelectTradeType().equals(MSPayType.API_WXQRCODE.getType())) {
			
		}else if (req.getSelectTradeType().equals(MSPayType.API_WXSCAN.getType())) {
			if(req.getRemark() == null || req.getRemark().equals("")) {
				return null;
			}
			//base64加密
			
		}else if (req.getSelectTradeType().equals(MSPayType.API_ZFBQRCODE.getType())) {
			
		}else if (req.getSelectTradeType().equals(MSPayType.API_ZFBSCAN.getType())) {
			if(req.getRemark() == null || req.getRemark().equals("")) {
				return null;
			}
			//base64加密
			
		}else if (req.getSelectTradeType().equals(MSPayType.H5_ZFBJSAPI.getType())) {
			
		}
		//对象加密
		String json = JSON.toJSONString(req);
		String backCode = HttpClientUtil.doPostJson(MSBankConstants.UNION_PAY_URL_TEST, json);
		//请求返回解密-》转换为对象
		return null;
	}

	public String searchPay() {
		return null;
	}

	public String refundPay() {
		return null;
	}

	public String checkPayList() {
		return null;
	}

}
