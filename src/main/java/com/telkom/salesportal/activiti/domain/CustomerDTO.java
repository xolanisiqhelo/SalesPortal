package com.telkom.salesportal.activiti.domain;

import java.io.Serializable;
import java.util.List;

public class CustomerDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String surname;
	private List<LeadInformation> leadInformation;
	private boolean existingCustomer;
	private String title;
	private String firstName;
	private String idType;
	private String idNo;
	private String gender;
	private String dob;
	private String mobileNo;
	private String email;
	private String unitNo;
	private String suburb;
	private String city;
	private String residentialPostCode;
	private boolean sameAddresses;
	private String invoiceDeliveryOption;
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public List<LeadInformation> getLeadInformation() {
		return leadInformation;
	}
	public void setLeadInformation(List<LeadInformation> leadInformation) {
		this.leadInformation = leadInformation;
	}
	public boolean isExistingCustomer() {
		return existingCustomer;
	}
	public void setExistingCustomer(boolean existingCustomer) {
		this.existingCustomer = existingCustomer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUnitNo() {
		return unitNo;
	}
	public void setUnitNo(String unitNo) {
		this.unitNo = unitNo;
	}
	public String getSuburb() {
		return suburb;
	}
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getResidentialPostCode() {
		return residentialPostCode;
	}
	public void setResidentialPostCode(String residentialPostCode) {
		this.residentialPostCode = residentialPostCode;
	}
	public boolean isSameAddresses() {
		return sameAddresses;
	}
	public void setSameAddresses(boolean sameAddresses) {
		this.sameAddresses = sameAddresses;
	}
	public String getInvoiceDeliveryOption() {
		return invoiceDeliveryOption;
	}
	public void setInvoiceDeliveryOption(String invoiceDeliveryOption) {
		this.invoiceDeliveryOption = invoiceDeliveryOption;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
