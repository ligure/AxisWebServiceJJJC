package com.dc.jjjc.ws.client;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

public class Test {
    public static void main(String[] args) throws Exception {
	Long time1 = System.currentTimeMillis();
	Service service = new Service();
	Call call = (Call) service.createCall();
	call.setTargetEndpointAddress("http://10.58.1.246:8080/EliteGeneralWS/EliteDBWSImpl.jws");
	call.setOperationName("query");
	String res = (String) call.invoke(new Object[] { "q_letv_crm_infosrc",
		"<root><params></params></root>" });
	Long time2 = System.currentTimeMillis();
	System.out.println(time2-time1);
	System.out.println(res);
	
    }
}
