package com.telkom.salesportal.activiti.delegate;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.google.gson.Gson;
import com.squareup.okhttp.Response;
import com.telkom.salesportal.activiti.domain.CustomerDTO;
import com.telkom.salesportal.activiti.utils.HttpClient;

public class SavePersonalDeatils  implements JavaDelegate {
	
	HttpClient httpClient = new HttpClient();
	
	public void execute(DelegateExecution execution) {	
		
		
		CustomerDTO cust = (CustomerDTO) execution.getVariable("customer");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(cust);
		System.out.println("object expected" + json);
		
		Response response = httpClient.post("http://localhost:8002/salesportal/api/customer", json);
		
		
		
		int savePersonalDeatils=response.code();
		
		//execution.setVariable("savePersonalDeatils", savePersonalDeatils);
		
	   System.out.println("create customer code"+savePersonalDeatils);
	   
	   if(savePersonalDeatils==200)
	   {
		   execution.setVariable("savePersonalDeatils", true);
	   }
	   else
	   {
		   execution.setVariable("savePersonalDeatils", false);
		   
	   }
		
	}


}
