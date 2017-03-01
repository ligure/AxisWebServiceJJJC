package com.dc.jjjc.ws.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataGroup {
	private String name;
	private String xmlns;
	private List attributes = new ArrayList();
	private List dataItem = new ArrayList();

	public DataGroup(String name, String xmlns) {
		this.name = name;
		this.xmlns = xmlns;
	}

	public String getName() {
		return name == null ? "" : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getXmlns() {
		return xmlns == null ? "" : xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	public List getAttributes() {
		return attributes;
	}

	public void setAttributes(List attributes) {
		this.attributes = attributes;
	}

	public List getDataItem() {
		return dataItem;
	}

	public void setDataItem(List dataItem) {
		this.dataItem = dataItem;
	}

	public void addAttribute(Map map) {
		attributes.add(map);
	}

	public void addItem(DataItem item) {
		dataItem.add(item);
	}

}
