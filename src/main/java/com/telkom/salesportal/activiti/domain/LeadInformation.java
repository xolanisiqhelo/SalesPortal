package com.telkom.salesportal.activiti.domain;

import java.io.Serializable;

public class LeadInformation implements Serializable {

	private static final long serialVersionUID = 1L;
		private Integer qmsNumber;
	
		public Integer getQmsNumber() {
			return qmsNumber;
		}
	
		public void setQmsNumber(Integer qmsNumber) {
			this.qmsNumber = qmsNumber;
		}
}
