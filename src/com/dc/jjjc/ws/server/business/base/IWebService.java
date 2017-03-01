package com.dc.jjjc.ws.server.business.base;

import com.dc.jjjc.ws.exception.WebServiceException;
import com.dc.jjjc.ws.message.MessageHandler;

public interface IWebService {

	/**
	 * ����ҵ���߼�
	 * 
	 * @param handler
	 * @throws WebServiceException
	 */
	public void doService(MessageHandler handler) throws WebServiceException;

	/**
	 * ��֤������Ϣ
	 * 
	 * @param handler
	 * @return
	 */
	public boolean validate(MessageHandler handler);

	/**
	 * �ɹ���Ӧ��������
	 * 
	 * @param handler
	 */
	public void onSuccess(MessageHandler handler);

	/**
	 * �쳣��Ӧ��������
	 * 
	 * @param handler
	 */
	public void onException(MessageHandler handler);

	/**
	 * ��䱨��ͷ
	 * 
	 * @param handler
	 */
	public void fillMessageHead(MessageHandler handler);

	/**
	 * ҵ����ɹ�����䱨����
	 * 
	 * @param handler
	 * @throws WebServiceException
	 */
	public void fillMessageBody(MessageHandler handler)
			throws WebServiceException;

	/**
	 * ҵ��������쳣����䱨����
	 * 
	 * @param handler
	 */
	public void fillExceptionMessageBody(MessageHandler handler);

}
