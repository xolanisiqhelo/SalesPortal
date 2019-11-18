package com.telkom.salesportal.activiti.delegate;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.squareup.okhttp.Response;
import com.telkom.salesportal.activiti.utils.HttpClient;

public class CheckBankDetails implements JavaDelegate {
	
	HttpClient httpClient = new HttpClient();
	
	
	public void execute(DelegateExecution execution) {	
		System.out.println("billing details!!!!!!!!!!!!!!!!!");
		
		Response response=getBillingAccount();
		
//		int customerCheckStatus=response.code();
		
		System.out.println("billing details"+response);
		
	}
	
	
	public Response getBillingAccount(){
		
		return httpClient.get("http://localhost:8002/salesportal/api/billing-account?id=12");
		
	}


}
