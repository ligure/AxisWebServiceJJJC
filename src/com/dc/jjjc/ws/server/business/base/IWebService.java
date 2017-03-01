package com.dc.jjjc.ws.server.business.base;

import com.dc.jjjc.ws.exception.WebServiceException;
import com.dc.jjjc.ws.message.MessageHandler;

public interface IWebService {

	/**
	 * 处理业务逻辑
	 * 
	 * @param handler
	 * @throws WebServiceException
	 */
	public void doService(MessageHandler handler) throws WebServiceException;

	/**
	 * 验证请求消息
	 * 
	 * @param handler
	 * @return
	 */
	public boolean validate(MessageHandler handler);

	/**
	 * 成功响应后续处理
	 * 
	 * @param handler
	 */
	public void onSuccess(MessageHandler handler);

	/**
	 * 异常响应后续处理
	 * 
	 * @param handler
	 */
	public void onException(MessageHandler handler);

	/**
	 * 填充报文头
	 * 
	 * @param handler
	 */
	public void fillMessageHead(MessageHandler handler);

	/**
	 * 业务处理成功，填充报文体
	 * 
	 * @param handler
	 * @throws WebServiceException
	 */
	public void fillMessageBody(MessageHandler handler)
			throws WebServiceException;

	/**
	 * 业务处理出现异常，填充报文体
	 * 
	 * @param handler
	 */
	public void fillExceptionMessageBody(MessageHandler handler);

}
