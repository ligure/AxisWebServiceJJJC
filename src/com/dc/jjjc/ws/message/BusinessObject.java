package com.dc.jjjc.ws.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BusinessObject {
	private String name;
	private String xmlns;
	private List attributes = new ArrayList();
	private List dataGroup = new ArrayList();

	public BusinessObject(String name, String xmlns) {
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

	public List getDataGroup() {
		return dataGroup;
	}

	public void setDataGroup(List dataGroup) {
		this.dataGroup = dataGroup;
	}

	public void addAttribute(Map map) {
		attributes.add(map);
	}

	public void addGroup(DataGroup group) {
		dataGroup.add(group);
	}
}
