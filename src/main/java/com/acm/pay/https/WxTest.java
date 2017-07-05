package com.acm.pay.https;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class WxTest {
	private static String url = "https://api.weixin.qq.com/cgi-bin/token";
	private static String grant_type = "client_credential";
	private static String appid = "wx46bff3d2ce07256f";
	private static String secret = "b91aecbadaf5cff1a84d47d4f38a27d4";

	public static void main(String[] args) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("grant_type", grant_type);
		param.put("appid", appid);
		param.put("secret", secret);
		String access = HttpRequest.doGet(url, param);
		// String转json对象
		JSONObject obj = JSONObject.parseObject(access);
		// json转对象
		WxAccess acc = (WxAccess) obj.toJavaObject(obj, WxAccess.class);

		System.out.println(access);
		System.out.println(acc.getAccess_token());
		System.out.println(acc.getExpires_in());
	}
}
