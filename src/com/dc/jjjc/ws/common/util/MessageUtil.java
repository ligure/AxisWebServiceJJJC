package com.dc.jjjc.ws.common.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.dc.jjjc.ws.common.WsConstant;
import com.dc.jjjc.ws.exception.ExceptionConstant;
import com.dc.jjjc.ws.exception.WebServiceException;
import com.dc.jjjc.ws.message.BusinessObject;
import com.dc.jjjc.ws.message.DataGroup;
import com.dc.jjjc.ws.message.DataItem;
import com.dc.jjjc.ws.message.MessageHandler;
import com.dc.jjjc.ws.message.MessageHead;

public class MessageUtil {

	protected final Logger logger = Logger.getLogger(getClass());

	/**
	 * 格式化输出XML字符串
	 * 
	 * @param document
	 * @param charset
	 * @return
	 */
	public static String formatXML(Document document, String charset) {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding(charset);
		StringWriter sw = new StringWriter();
		XMLWriter xw = new XMLWriter(sw, format);
		try {
			xw.write(document);
			xw.flush();
			xw.close();
		} catch (IOException e) {
		}
		return sw.toString();
	}

	/**
	 * 创建请求消息报文
	 * 
	 * @param handler
	 * @throws WebServiceException
	 */
	public static void createMessage(MessageHandler handler)
			throws WebServiceException {
		Document document = handler.getDocument();
		Element root = document.getRootElement();
		Element head = root.addElement("head");
		MessageHead messageHead = handler.getMessageHead();
		Element serviceId = head.addElement("service_id");
		serviceId.setText(messageHead.getServiceId());
		Element operation = head.addElement("operation");
		operation.setText(messageHead.getOperation());
		Element systemCode = head.addElement("systemCode");
		systemCode.setText(messageHead.getSystemCode());
		Element filepath = head.addElement("filepath");
		filepath.setText(messageHead.getFilepath());
		Element tranId = head.addElement("tran_id");
		tranId.setText(messageHead.getTranId());
		Element condition = head.addElement("condition");
		condition.setText(messageHead.getCondition());
		Element rtnCode = head.addElement("rtn_code");
		rtnCode.setText(messageHead.getRtnCode());
		Element rtnMsg = head.addElement("rtn_msg");
		rtnMsg.setText(messageHead.getRtnMsg());
		Element user = head.addElement("user");
		user.setText(messageHead.getUser());
		Element password = head.addElement("password");
		password.setText(messageHead.getPassword());
		Element body = root.addElement("body");
		List boList = handler.getMessageBody().getBusinessObject();
		if (boList != null) {
			Iterator boIterator = boList.iterator();
			BusinessObject bo = null;
			Element boElement = null;
			List boAttrList = null;
			Iterator boAttrIterator = null;
			Map map = null;
			String key = "";
			String value = "";
			List dataGroup = null;
			Iterator groupIterator = null;
			DataGroup group = null;
			Element groupElement = null;
			List groupAttrList = null;
			Iterator grooupAttrIterator = null;
			List dataItem = null;
			Iterator itemIterator = null;
			DataItem item = null;
			Element itemElement = null;
			List itemAttrList = null;
			Iterator itemAttrIterator = null;
			while (boIterator.hasNext()) {
				bo = (BusinessObject) boIterator.next();
				if ("".equals(bo.getName())) {
					throw new WebServiceException(
							ExceptionConstant.LOCAL_CALL_EXCEPTION_CODE_001,
							ExceptionConstant.LOCAL_CALL_EXCEPTION_001);
				}
				// 添加业务对象节点
				boElement = body.addElement(bo.getName(), bo.getXmlns());
				boAttrList = bo.getAttributes();
				if (boAttrList != null) {
					boAttrIterator = boAttrList.iterator();
					while (boAttrIterator.hasNext()) {
						map = (Map) boAttrIterator.next();
						key = map.get("key") != null ? (String) map.get("key")
								: "";
						value = map.get("value") != null ? (String) map
								.get("value") : "";
						if ("".equals(key)) {
							throw new WebServiceException(
									ExceptionConstant.LOCAL_CALL_EXCEPTION_CODE_002,
									ExceptionConstant.LOCAL_CALL_EXCEPTION_002);
						}
						boElement.addAttribute(key, value);
					}
				}
				dataGroup = bo.getDataGroup();
				if (dataGroup != null) {
					groupIterator = dataGroup.iterator();
					while (groupIterator.hasNext()) {
						group = (DataGroup) groupIterator.next();
						if ("".equals(group.getName())) {
							throw new WebServiceException(
									ExceptionConstant.LOCAL_CALL_EXCEPTION_CODE_003,
									ExceptionConstant.LOCAL_CALL_EXCEPTION_003);
						}
						// 添加数据组节点
						groupElement = boElement.addElement(group.getName(),
								group.getXmlns());
						groupAttrList = group.getAttributes();
						if (groupAttrList != null) {
							grooupAttrIterator = groupAttrList.iterator();
							while (grooupAttrIterator.hasNext()) {
								map = (Map) grooupAttrIterator.next();
								key = map.get("key") != null ? (String) map
										.get("key") : "";
								value = map.get("value") != null ? (String) map
										.get("value") : "";
								if ("".equals(key)) {
									throw new WebServiceException(
											ExceptionConstant.LOCAL_CALL_EXCEPTION_CODE_004,
											ExceptionConstant.LOCAL_CALL_EXCEPTION_004);
								}
								groupElement.addAttribute(key, value);
							}
						}
						dataItem = group.getDataItem();
						if (dataItem != null) {
							itemIterator = dataItem.iterator();
							while (itemIterator.hasNext()) {
								item = (DataItem) itemIterator.next();
								if ("".equals(item.getName())) {
									throw new WebServiceException(
											ExceptionConstant.LOCAL_CALL_EXCEPTION_CODE_005,
											ExceptionConstant.LOCAL_CALL_EXCEPTION_005);
								}
								// 添加数据项节点
								itemElement = groupElement.addElement(item
										.getName());
								itemElement.setText(item.getText());
								itemAttrList = item.getAttributes();
								if (itemAttrList != null) {
									itemAttrIterator = itemAttrList.iterator();
									while (itemAttrIterator.hasNext()) {
										map = (Map) itemAttrIterator.next();
										key = map.get("key") != null ? (String) map
												.get("key")
												: "";
										value = map.get("value") != null ? (String) map
												.get("value")
												: "";
										if ("".equals(key)) {
											throw new WebServiceException(
													ExceptionConstant.LOCAL_CALL_EXCEPTION_CODE_006,
													ExceptionConstant.LOCAL_CALL_EXCEPTION_006);
										}
										itemElement.addAttribute(key, value);
									}
								}
							}
						}
					}
				}
			}
		}
		handler.setMessage(MessageUtil.formatXML(document,
				WsConstant.XML_ENCODING));
	}
}
