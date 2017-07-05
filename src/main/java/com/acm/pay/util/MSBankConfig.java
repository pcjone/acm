package com.acm.pay.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * 读取配置文件
 * @author panlei
 *
 */
public class MSBankConfig {
	
	public static final String CONFIG_PATH = "/props/msbank.properties";
	public static Properties props = new Properties();
	public static boolean isInited = false;
	
	/**
	 * 初始化配置文件
	 */
	public static void init() {
		if(!isInited) {
			InputStream inStream = null;
			inStream = MSBankConfig.class.getResourceAsStream(CONFIG_PATH);
			try {
				props.load(inStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 根据key获取参数
	 * @param name
	 * @return
	 */
	public static String getName(String key) {
		init();
		return props.getProperty(key);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(MSBankConfig.getName("name"));
	}
}
