package com.dc.jjjc.ws.message;

import java.util.ArrayList;
import java.util.List;

public class MessageBody {

	private List businessObject = new ArrayList();

	public List getBusinessObject() {
		return businessObject;
	}

	public void setBusinessObject(List businessObject) {
		this.businessObject = businessObject;
	}

	public void addBusinessObject(BusinessObject bo) {
		businessObject.add(bo);
	}

}
