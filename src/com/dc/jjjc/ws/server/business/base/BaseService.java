package com.dc.jjjc.ws.server.business.base;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;

import com.dc.jjjc.ws.common.WsConstant;
import com.dc.jjjc.ws.common.util.MessageUtil;
import com.dc.jjjc.ws.exception.ExceptionConstant;
import com.dc.jjjc.ws.exception.WebServiceException;
import com.dc.jjjc.ws.message.BusinessObject;
import com.dc.jjjc.ws.message.DataGroup;
import com.dc.jjjc.ws.message.DataItem;
import com.dc.jjjc.ws.message.MessageHandler;

public abstract class BaseService implements IWebService {

	protected final Logger logger = Logger.getLogger(getClass());

	/**
	 * 填充报文头
	 */
	public void fillMessageHead(MessageHandler handler) {
		Document document = handler.getDocument();
		document.selectSingleNode("service/head/rtn_code").setText(
				handler.getMessageHead().getRtnCode());
		document.selectSingleNode("service/head/rtn_msg").setText(
				handler.getMessageHead().getRtnMsg());
		handler.setMessage(MessageUtil.formatXML(document,
				WsConstant.XML_ENCODING));
	}

	/**
	 * 业务处理成功，填充报文体
	 */
	public void fillMessageBody(MessageHandler handler)
			throws WebServiceException {
		Document document = handler.getDocument();
		Element root = document.getRootElement();
		root.remove(document.selectSingleNode("service/body"));
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
							ExceptionConstant.LOCAL_SERVER_EXCEPTION_CODE_007,
							ExceptionConstant.LOCAL_SERVER_EXCEPTION_007);
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
									ExceptionConstant.LOCAL_SERVER_EXCEPTION_CODE_008,
									ExceptionConstant.LOCAL_SERVER_EXCEPTION_008);
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
									ExceptionConstant.LOCAL_SERVER_EXCEPTION_CODE_009,
									ExceptionConstant.LOCAL_SERVER_EXCEPTION_009);
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
											ExceptionConstant.LOCAL_SERVER_EXCEPTION_CODE_010,
											ExceptionConstant.LOCAL_SERVER_EXCEPTION_010);
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
											ExceptionConstant.LOCAL_SERVER_EXCEPTION_CODE_011,
											ExceptionConstant.LOCAL_SERVER_EXCEPTION_011);
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
													ExceptionConstant.LOCAL_SERVER_EXCEPTION_CODE_012,
													ExceptionConstant.LOCAL_SERVER_EXCEPTION_012);
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

	/**
	 * 业务处理出现异常，填充报文体
	 */
	public void fillExceptionMessageBody(MessageHandler handler) {
		Document document = handler.getDocument();
		Element root = document.getRootElement();
		root.remove(document.selectSingleNode("service/body"));
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
				if (!"".equals(bo.getName())) {
					// 添加业务对象节点
					boElement = body.addElement(bo.getName(), bo.getXmlns());
					boAttrList = bo.getAttributes();
					if (boAttrList != null) {
						boAttrIterator = boAttrList.iterator();
						while (boAttrIterator.hasNext()) {
							map = (Map) boAttrIterator.next();
							key = map.get("key") != null ? (String) map
									.get("key") : "";
							value = map.get("value") != null ? (String) map
									.get("value") : "";
							if (!"".equals(key)) {
								boElement.addAttribute(key, value);
							}
						}
					}
					dataGroup = bo.getDataGroup();
					if (dataGroup != null) {
						groupIterator = dataGroup.iterator();
						while (groupIterator.hasNext()) {
							group = (DataGroup) groupIterator.next();
							if (!"".equals(group.getName())) {
								// 添加数据组节点
								groupElement = boElement.addElement(group
										.getName(), group.getXmlns());
								groupAttrList = group.getAttributes();
								if (groupAttrList != null) {
									grooupAttrIterator = groupAttrList
											.iterator();
									while (grooupAttrIterator.hasNext()) {
										map = (Map) grooupAttrIterator.next();
										key = map.get("key") != null ? (String) map
												.get("key")
												: "";
										value = map.get("value") != null ? (String) map
												.get("value")
												: "";
										if (!"".equals(key)) {
											groupElement.addAttribute(key,
													value);
										}
									}
								}
								dataItem = group.getDataItem();
								if (dataItem != null) {
									itemIterator = dataItem.iterator();
									while (itemIterator.hasNext()) {
										item = (DataItem) itemIterator.next();
										if (!"".equals(item.getName())) {
											// 添加数据项节点
											itemElement = groupElement
													.addElement(item.getName());
											itemElement.setText(item.getText());
											itemAttrList = item.getAttributes();
											if (itemAttrList != null) {
												itemAttrIterator = itemAttrList
														.iterator();
												while (itemAttrIterator
														.hasNext()) {
													map = (Map) itemAttrIterator
															.next();
													key = map.get("key") != null ? (String) map
															.get("key")
															: "";
													value = map.get("value") != null ? (String) map
															.get("value")
															: "";
													if (!"".equals(key)) {
														itemElement
																.addAttribute(
																		key,
																		value);
													}
												}
											}
										}
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
