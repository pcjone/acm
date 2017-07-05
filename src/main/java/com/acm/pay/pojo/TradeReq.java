package com.acm.pay.pojo;

import com.acm.pay.constants.MSBankConstants;
import com.acm.pay.enums.MSPayType;

/**
 * 统一下单请求体
 * @author panlei
 *
 */
public class TradeReq {
	/**
	 * 接入平台号 	
	 */
	private String platformId;
	/**
	 * 民生商户号
	 */
	private String merchantNo;
	/**
	 * 支付类型
	 */
	private String selectTradeType;
	/**
	 * 交易金额,以分为单位
	 */
	private Integer amount;
	/**
	 * 订单信息
	 */
	private String orderInfo;
	/**
	 * 商户流水
	 */
	private String merchantSeq;
	/**
	 * 订单日期yyyyMMdd
	 */
	private String transDate;
	/**
	 * 订单时间yyyyMMddHHmmssSSS
	 */
	private String transTime;
	/**
	 * 通知地址
	 */
	private String notifyUrl;
	/**
	 * 备注信息(反扫模式下该部分必输，填扫描客户二维码Base64后的值)
	 */
	private String remark;
	/**
	 * 子商户appId(公众号支付API下，该部分必输，填子商户appId)
	 */
	private String subAppId;
	/**
	 * 子商户openId(公众号支付API下，该部分必输，填子商户openId)
	 */
	private String subOpenId;
	
	public TradeReq () {
		super();
	}
	
	public TradeReq(String platformId, String merchantNo, String selectTradeType, Integer amount, String orderInfo,
			String merchantSeq, String transDate, String transTime, String notifyUrl, String remark, String subAppId,
			String subOpenId) {
		super();
		this.platformId = platformId;
		this.merchantNo = merchantNo;
		this.selectTradeType = selectTradeType;
		this.amount = amount;
		this.orderInfo = orderInfo;
		this.merchantSeq = merchantSeq;
		this.transDate = transDate;
		this.transTime = transTime;
		this.notifyUrl = notifyUrl;
		this.remark = remark;
		this.subAppId = subAppId;
		this.subOpenId = subOpenId;
	}
	public String getPlatformId() {
		return platformId;
	}
	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}
	public String getMerchantNo() {
		return merchantNo;
	}
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	public String getSelectTradeType() {
		return selectTradeType;
	}
	public void setSelectTradeType(String selectTradeType) {
		this.selectTradeType = selectTradeType;
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
	public String getMerchantSeq() {
		return merchantSeq;
	}
	public void setMerchantSeq(String merchantSeq) {
		this.merchantSeq = merchantSeq;
	}
	public String getTransDate() {
		return transDate;
	}
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}
	public String getTransTime() {
		return transTime;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSubAppId() {
		return subAppId;
	}
	public void setSubAppId(String subAppId) {
		this.subAppId = subAppId;
	}
	public String getSubOpenId() {
		return subOpenId;
	}
	public void setSubOpenId(String subOpenId) {
		this.subOpenId = subOpenId;
	}
	@Override
	public String toString() {
		return "TradeReq [platformId=" + platformId + ", merchantNo=" + merchantNo + ", selectTradeType="
				+ selectTradeType + ", amount=" + amount + ", orderInfo=" + orderInfo + ", merchantSeq=" + merchantSeq
				+ ", transDate=" + transDate + ", transTime=" + transTime + ", notifyUrl=" + notifyUrl + ", remark="
				+ remark + ", subAppId=" + subAppId + ", subOpenId=" + subOpenId + "]";
	}
	
	
	public TradeReq(MSPayType type) {
		this.platformId = MSBankConstants.PLATEFORM_ID;
		this.merchantNo = MSBankConstants.MERCHANT_NO;
		this.notifyUrl = MSBankConstants.NOTIFY_URL;
		this.selectTradeType = type.getType();
	}
	
}
