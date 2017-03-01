package com.dc.jjjc.ws.server.portal;

import org.apache.log4j.Logger;

import com.dc.jjjc.ws.common.util.BeanFactory;
import com.dc.jjjc.ws.exception.WebServiceException;
import com.dc.jjjc.ws.message.MessageHandler;
import com.dc.jjjc.ws.server.business.base.IWebService;

public class JszhService {

	protected final Logger logger = Logger.getLogger(getClass());

	public String onMessage(String message) {
		logger.info("进入服务调用，请求消息为：" + message);
		MessageHandler handler = null;
		try {
			handler = MessageHandler.getInstance(message);
		} catch (WebServiceException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			return errorMessage(message, e);
		}
		IWebService bizService = null;
		try {
			bizService = (IWebService) BeanFactory.getBean("WS_"
					+ handler.getMessageHead().getTranId());
		} catch (WebServiceException e) {
			logger.error(e.getMessage() + ",服务ID为WS_"
					+ handler.getMessageHead().getTranId(), e);
			e.printStackTrace();
			return errorMessage(message, e);
		}
		logger.info("开始调用业务服务，业务服务为：" + bizService.getClass());
		try {
			if (bizService.validate(handler)) {
				bizService.doService(handler);
				bizService.fillMessageHead(handler);
				bizService.fillMessageBody(handler);
			} else {
				logger.info("请求消息没有通过验证，请求消息为：" + message);
				bizService.fillMessageHead(handler);
				bizService.fillMessageBody(handler);
			}
			bizService.onSuccess(handler);
		} catch (WebServiceException e) {
			logger.error(e.getMessage(), e);
			e.printStackTrace();
			handler.getMessageHead().setRtnCode(e.getCode());
			handler.getMessageHead().setRtnMsg(e.getMessage());
			bizService.fillMessageHead(handler);
			bizService.fillExceptionMessageBody(handler);
			bizService.onException(handler);
		}
		logger.info("结束服务调用，业务服务为：" + bizService.getClass());
		logger.info("返回消息为：" + handler.getMessage());
		handler.setDocument(null);
		handler.setMessageHead(null);
		handler.setMessageBody(null);
		return handler.getMessage();
	}

	private String errorMessage(String message, WebServiceException e) {
		String retMsg = message.replaceAll("<rtn_code>[\\s\\S]*</rtn_code>",
				"<rtn_code>" + e.getCode() + "</rtn_code>");
		retMsg = retMsg.replaceAll("<rtn_msg>[\\s\\S]*</rtn_msg>", "<rtn_msg>"
				+ e.getMessage() + "</rtn_msg>");
		return retMsg;
	}

}
