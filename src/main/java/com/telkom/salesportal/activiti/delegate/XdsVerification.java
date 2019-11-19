package com.telkom.salesportal.activiti.delegate;


import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;





public class XdsVerification implements JavaDelegate {	
	
	public void execute(DelegateExecution execution) {	
		
		String clientId = (String) execution.getVariable("clientId");
		
		System.out.println("clientId: " +  execution.getVariable("clientId"));
		
		boolean xdsVerification = xdsResponse(clientId);
	
		execution.setVariable("xdsVerification", xdsVerification);
		
		
        if (xdsVerification) {
            System.out.println("pass xds!");
            //arg0.setVariable("result", "1");
        }   
        else  {
            System.out.println("failed xds!");           
            //arg0.setVariable("result", "0");
        }
 
    }
	
	public boolean xdsResponse(String id) {
		return true		;
	}
}
