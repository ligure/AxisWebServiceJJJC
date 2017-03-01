package com.dc.jjjc.ws.message;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import com.dc.jjjc.ws.exception.ExceptionConstant;
import com.dc.jjjc.ws.exception.WebServiceException;

public class MessageHandler {

	protected static final Logger logger = Logger
			.getLogger(MessageHandler.class);

	/**
	 * 根据请求消息获取MessageHandler实例
	 * 
	 * @param message
	 * @return
	 * @throws WebServiceException
	 */
	public static MessageHandler getInstance(String message)
			throws WebServiceException {
		MessageHandler handler = new MessageHandler();
		Document document = null;
		try {
			document = DocumentHelper.parseText(message);
		} catch (DocumentException e) {
			throw new WebServiceException(
					ExceptionConstant.REMOTE_CALL_EXCEPTION_CODE_001,
					ExceptionConstant.REMOTE_CALL_EXCEPTION_001);
		}
		handler.setDocument(document);
		handler.setMessage(message);
		handler.setMessageHead(new MessageHead());
		String serviceId = document.selectSingleNode("service/head/service_id")
				.getText();
		if ("".equals(serviceId)) {
			// throw new WebServiceException(
			// ExceptionConstant.REMOTE_CALL_EXCEPTION_CODE_002,
			// ExceptionConstant.REMOTE_CALL_EXCEPTION_002);
		}
		handler.getMessageHead().setServiceId(serviceId);
		String operation = document.selectSingleNode("service/head/operation")
				.getText();
		if ("".equals(operation)) {
			// throw new WebServiceException(
			// ExceptionConstant.REMOTE_CALL_EXCEPTION_CODE_003,
			// ExceptionConstant.REMOTE_CALL_EXCEPTION_003);
		}
		handler.getMessageHead().setOperation(operation);
		String systemCode = document
				.selectSingleNode("service/head/systemCode").getText();
		if ("".equals(systemCode)) {
			// throw new WebServiceException(
			// ExceptionConstant.REMOTE_CALL_EXCEPTION_CODE_004,
			// ExceptionConstant.REMOTE_CALL_EXCEPTION_004);
		}
		handler.getMessageHead().setSystemCode(systemCode);
		String tranId = document.selectSingleNode("service/head/tran_id")
				.getText();
		if ("".equals(tranId)) {
			throw new WebServiceException(
					ExceptionConstant.REMOTE_CALL_EXCEPTION_CODE_005,
					ExceptionConstant.REMOTE_CALL_EXCEPTION_005);
		}
		handler.getMessageHead().setTranId(tranId);
		String filepath = document.selectSingleNode("service/head/filepath")
				.getText();
		handler.getMessageHead().setFilepath(filepath);
		String condition = document.selectSingleNode("service/head/condition")
				.getText();
		handler.getMessageHead().setCondition(condition);
		String rtnCode = document.selectSingleNode("service/head/rtn_code")
				.getText();
		handler.getMessageHead().setRtnCode(rtnCode);
		String rtnMsg = document.selectSingleNode("service/head/rtn_msg")
				.getText();
		handler.getMessageHead().setRtnMsg(rtnMsg);
		handler.setMessageBody(new MessageBody());
		return handler;
	}

	/**
	 * 获取一个新的MessageHandler实例
	 * 
	 * @param message
	 * @return
	 * @throws WebServiceException
	 */
	public static MessageHandler getInstance() {
		MessageHandler handler = new MessageHandler();
		Document document = DocumentHelper.createDocument();
		document.addElement("service");
		handler.setDocument(document);
		handler.setMessageHead(new MessageHead());
		handler.setMessageBody(new MessageBody());
		return handler;
	}

	private Document document;

	private String message;

	private MessageHead messageHead;

	private MessageBody messageBody;

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageHead getMessageHead() {
		return messageHead;
	}

	public void setMessageHead(MessageHead messageHead) {
		this.messageHead = messageHead;
	}

	public MessageBody getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(MessageBody messageBody) {
		this.messageBody = messageBody;
	}

}
