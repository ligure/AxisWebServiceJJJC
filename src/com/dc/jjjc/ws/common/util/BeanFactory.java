package com.dc.jjjc.ws.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.dc.jjjc.ws.exception.ExceptionConstant;
import com.dc.jjjc.ws.exception.WebServiceException;

public class BeanFactory {

	private static ApplicationContext context;
	private static String[] path = { "config/WebService/applicationContext-jszh.xml" };

	public BeanFactory() {

	}

	public static synchronized ApplicationContext getApplicationContext() {
		if (context == null) {
			context = new FileSystemXmlApplicationContext(path);
		}
		return context;
	}

	public static Object getBean(String beanId) throws WebServiceException {
		try {
			return context.getBean(beanId);
		} catch (BeansException e) {
			throw new WebServiceException(
					ExceptionConstant.LOCAL_SERVER_EXCEPTION_CODE_001,
					ExceptionConstant.LOCAL_SERVER_EXCEPTION_001);
		}
	}

	static {
		getApplicationContext();
	}

}
