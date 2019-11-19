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
		
		
		int customerBankDetails=response.code();
	
		if (customerBankDetails==200)
		{
			execution.setVariable("customerBankDetails", "true");
			System.out.println("billing details"+ customerBankDetails);
		}else
		{
			execution.setVariable("customerBankDetails", "false");
		}
	
		
	}
	
	
	public Response getBillingAccount(){
		
		return httpClient.get("http://localhost:8002/salesportal/api/billing-account?id=12");
		
	}


}
