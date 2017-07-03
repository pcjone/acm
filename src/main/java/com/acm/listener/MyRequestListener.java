package com.acm.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import org.apache.log4j.Logger;
/**
 * 
* @ClassName: MyRequestListener 
* @Description: 监听Request对象
* @author panlei 446756738@qq.com
* @date 2017年6月29日 下午3:14:33 
*
 */
public class MyRequestListener implements ServletRequestListener {
	private Logger logger = Logger.getLogger(MyRequestListener.class);
	
	public void requestDestroyed(ServletRequestEvent event) {
		logger.info("log>>>>requestDestroyed");
	}

	public void requestInitialized(ServletRequestEvent event) {
		logger.info("log>>>>requestInitialized");
	}

}
