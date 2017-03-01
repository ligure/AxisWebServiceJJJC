package com.dc.jjjc.ws.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataItem {
	private String name;
	private String text;
	private List attributes = new ArrayList();

	public DataItem(String name, String text) {
		this.name = name;
		this.text = text;
	}

	public String getName() {
		return name == null ? "" : name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text == null ? "" : text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List getAttributes() {
		return attributes;
	}

	public void setAttributes(List attributes) {
		this.attributes = attributes;
	}

	public void addAttribute(Map map) {
		attributes.add(map);
	}

}
