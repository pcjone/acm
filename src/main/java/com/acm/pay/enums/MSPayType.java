package com.acm.pay.enums;

public enum MSPayType {
	H5_WXJSAPI("H5_WXJSAPI", "微信公众号跳转支付"), API_WXQRCODE("API_WXQRCODE", "微信正扫"), API_WXSCAN("API_WXSCAN",
			"微信反扫"), API_ZFBQRCODE("API_ZFBQRCODE",
					"支付宝正扫"), API_ZFBSCAN("API_ZFBSCAN", "支付宝反扫"), H5_ZFBJSAPI("H5_ZFBJSAPI", "支付宝服务窗 ");
	private String type;
	private String note;

	private MSPayType(String type, String note) {
		this.type = type;
		this.note = note;
	}

	public static MSPayType getType(String type) {
		MSPayType[] values = MSPayType.values();
		for(MSPayType payType : values) {
			if(payType.type.equals(type)) {
				return payType;
			}
		}
		return null;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public static void main(String[] args) {
		MSPayType[] values = MSPayType.values();
		for(MSPayType type : values) {
			System.out.println(type.type);
		}
	}

}
