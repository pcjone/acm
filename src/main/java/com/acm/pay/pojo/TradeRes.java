package com.acm.pay.pojo;

public class TradeRes {
	/**
	 * E 订单失败 R 原订单成功，未支付（待支付）
	 */
	private String tradeStatus;
	/**
	 * 微信/支付宝正扫下单返回的是base64二维码字符串
	 * 公众号支付API下单返回的是prepay_id
	 */
	private String payInfo;
	/**
	 * 商户名
	 */
	private String merchantName;
	/**
	 * 商户订单号
	 */
	private String merchantSeq;
	/**
	 * 交易金额(分)
	 */
	private Integer amount;
	/**
	 * 订单详情
	 */
	private String orderInfo;
	/**
	 * 备注
	 */
	private String remark;
	
	public String getTradeStatus() {
		return tradeStatus;
	}
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	public String getPayInfo() {
		return payInfo;
	}
	public void setPayInfo(String payInfo) {
		this.payInfo = payInfo;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getMerchantSeq() {
		return merchantSeq;
	}
	public void setMerchantSeq(String merchantSeq) {
		this.merchantSeq = merchantSeq;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getOrderInfo() {
		return orderInfo;
	}
	public void setOrderInfo(String orderInfo) {
		this.orderInfo = orderInfo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	@Override
	public String toString() {
		return "TradeRes [tradeStatus=" + tradeStatus + ", payInfo=" + payInfo + ", merchantName=" + merchantName
				+ ", merchantSeq=" + merchantSeq + ", amount=" + amount + ", orderInfo=" + orderInfo + ", remark="
				+ remark + "]";
	}
	
}
