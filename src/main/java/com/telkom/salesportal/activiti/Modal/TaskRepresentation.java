package com.telkom.salesportal.activiti.Modal;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class TaskRepresentation {

	@Id
	@GeneratedValue
	
	private Long  id;
	private String name;
	private  String processIntanceId;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProcessIntanceId() {
		return processIntanceId;
	}
	public void setProcessIntanceId(String processIntanceId) {
		this.processIntanceId = processIntanceId;
	}
	
	
	
	
	
}
