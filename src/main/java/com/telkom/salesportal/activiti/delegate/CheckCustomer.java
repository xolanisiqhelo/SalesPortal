package com.telkom.salesportal.activiti.delegate;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.squareup.okhttp.Response;
import com.telkom.salesportal.activiti.utils.HttpClient;

public class CheckCustomer implements JavaDelegate {
	HttpClient httpClient = new HttpClient();
	
	public void execute(DelegateExecution execution) {	
		
		Response response = getCustomer();
		
		int customerCheckStatus = response.code();
		
		execution.setVariable("customerCheckStatus", customerCheckStatus);
		System.out.println("Customer Response code: " + customerCheckStatus);
    }
	
	public Response getCustomer(){
		return httpClient.get("http://localhost:8002/salesportal/api/customer?id=12");
		
	}
}
