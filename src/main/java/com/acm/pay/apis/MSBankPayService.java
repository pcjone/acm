package com.acm.pay.apis;

import com.acm.pay.pojo.TradeReq;
import com.acm.pay.pojo.TradeRes;

public interface MSBankPayService {
	/**
	 * 统一下单
	 * @return
	 */
	public TradeRes unionPay(TradeReq req) throws Exception;
	/**
	 * 交易查询
	 * @return
	 */
	public String searchPay();
	/**
	 * 退款api
	 * @return
	 */
	public String refundPay();
	/**
	 * 交易明细下载
	 * @return
	 */
	public String checkPayList();
}
