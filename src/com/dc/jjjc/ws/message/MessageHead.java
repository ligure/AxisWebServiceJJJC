package com.dc.jjjc.ws.message;

public class MessageHead {

	private String serviceId;
	private String operation;
	private String systemCode;
	private String filepath;
	private String tranId;
	private String condition;
	private String rtnCode;
	private String rtnMsg;
	private String user;
	private String password;

	public String getServiceId() {
		return serviceId == null ? "" : serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getOperation() {
		return operation == null ? "" : operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getSystemCode() {
		return systemCode == null ? "" : systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getFilepath() {
		return filepath == null ? "" : filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getTranId() {
		return tranId == null ? "" : tranId;
	}

	public void setTranId(String tranId) {
		this.tranId = tranId;
	}

	public String getCondition() {
		return condition == null ? "" : condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getRtnCode() {
		return rtnCode == null ? "" : rtnCode;
	}

	public void setRtnCode(String rtnCode) {
		this.rtnCode = rtnCode;
	}

	public String getRtnMsg() {
		return rtnMsg == null ? "" : rtnMsg;
	}

	public void setRtnMsg(String rtnMsg) {
		this.rtnMsg = rtnMsg;
	}

	public String getUser() {
		return user == null ? "" : user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password == null ? "" : password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
