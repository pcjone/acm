package com.acm.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

/**
 * 
 * @ClassName: MyHttpSessionListener
 * @Description: 监听Session对象(统计在线人数)
 * @author panlei 446756738@qq.com
 * @date 2017年6月29日 下午3:15:26
 *
 */
public class MyHttpSessionListener implements HttpSessionListener {
	private Logger logger = Logger.getLogger(MyHttpSessionListener.class);
	private ServletContext servletContext;

	/**
	 * session创建
	 */
	public void sessionCreated(HttpSessionEvent event) {
		servletContext = event.getSession().getServletContext();
		Integer numSessions = (Integer) servletContext.getAttribute("numSessions");
		if (numSessions == null) {
			numSessions = new Integer(1);
		} else {
			int count = numSessions.intValue();
			numSessions = new Integer(count + 1);
		}
		servletContext.setAttribute("numSessions", numSessions);
		logger.info("log>>>>sessionCreated"+numSessions);
	}

	/**
	 * session失效
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		servletContext = event.getSession().getServletContext();
		Integer numSessions = (Integer) servletContext.getAttribute("numSessions");
		if (numSessions == null) {
			numSessions = new Integer(0);
		} else {
			int count = numSessions.intValue();
			numSessions = new Integer(count - 1);
		}
		servletContext.setAttribute("numSessions", numSessions);
		logger.info("log>>>>sessionDestroyed:"+numSessions);
	}

}
