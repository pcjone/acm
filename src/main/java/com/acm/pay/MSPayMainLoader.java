package com.acm.pay;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.acm.pay.constants.MSBankConstants;
import com.acm.pay.enums.MSPayType;
import com.acm.pay.https.HttpRequest;
import com.acm.pay.pojo.TradeReq;
import com.acm.pay.util.MSBankSignUtil;
import com.alibaba.fastjson.JSON;

public class MSPayMainLoader {

	public static TradeReq initTradeReq() {
		TradeReq trade = new TradeReq(MSPayType.API_ZFBQRCODE);
		trade.setMerchantSeq(getMerchantSeq(trade));
		trade.setAmount(1);
		trade.setOrderInfo("商品信息");
		trade.setTransDate(getTimeOrDate("transDate"));
		trade.setTransTime(getTimeOrDate("transTime"));
		trade.setNotifyUrl(MSBankConstants.NOTIFY_URL);
		trade.setRemark("000000");
		return trade;
	}

	public static String getTimeOrDate(String type) {
		SimpleDateFormat sdf;
		if (type.equals("transTime")) {
			sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		} else if (type.equals("transDate")) {
			sdf = new SimpleDateFormat("yyyyMMdd");
		} else {
			sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		}
		return sdf.format(new Date());
	}

	public static String getMerchantSeq(TradeReq trade) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		return trade.getMerchantNo() + sdf.format(new Date());
	}

	public static void main(String[] args) {
		String requestText = MSBankSignUtil.getRequestContext(initTradeReq());
		String response = HttpRequest.doPostJson(MSBankConstants.UNION_PAY_URL_TEST, requestText);
		System.out.println(response);
	}
	
	public static void test() {
		String context="MIICmAYKKoEcz1UGAQQCA6CCAogwggKEAgECMYGdMIGaAgECgBRZlNziHI2cFrW5Ep1ym13ckOMoGTANBgkqgRzPVQGCLQMFAARwNSad++w4obbJnsh+CUgmjaX1Kf2j/YDSGL4ms1yL/GsyXF3uJA4gsV8diZ9ZlSNGmjbwx4E4IeoRWhMJkvrY0qMZCXShSIsKacXiKehm9au+w98rXoNsoNNH8ox7rfT7fXWUBFm4LDtXmKesEQwTcjCCAd0GCiqBHM9VBgEEAgEwGwYHKoEcz1UBaAQQ+TfRZyX82P0+Dv7HQE9cwYCCAbAmyBAU8Gx7uR00/lnzW6HwNmWIPwKzMaUCm8n7mL5hwyymWiUqx27eIPmvpnu1hwjM9zGJ6P4+0sN9DDQCeNbOIgzJIqjGV3deqNSs9t+ztJjq6TwV7UR/45tnuaxCGlg6acsG3EAIzy0+n3wlwBxNjARrM7RYsX9yj2DPoN4YPViO8wjTd4pDLSL7/ewt+G3rlrq1S53mWTxYcUqkVprU+40LFMtuLMqHCQ67vU+Ji3uXXBX2Z4hRbvE/SDyYD5Vmp0Vp/A3IJlck6w/VjtaxxT83Lz1iKTK/Oah9IdxFHTeZTQ21fggGl2WdHbftHUh5c5c/6Nxz0noNf1Nvi/PmCVFLjR3G5biJzmF2zp0D+DtnpHO8dQg7NbQJOe3sIylON0zSxYq+e2oAqJXuQYlnCiR6JZ2M3ZsUAlaKBB4xHmYus0/TZ2+GifPQaXQLuR6mlxlltPIXHwna9Ah0myiCzm8cMI/B72e5hHnTJfW/qgIW5G216jMrlHwax7QTORsqjSzY/V+tx8XbGniRLSQZaRFSlIMfNJYcV/rmPE0BZxcI26nnx1zd0QqMV7KPdX8=";
		
	}

}
