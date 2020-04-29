package com.niit.FirstChoiceBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class CustomerCredentials 
{
	
	@Id
	@Column(nullable = false, unique = true)
	String customer_Email;
	@Transient
	@Column(nullable=false)
	String  customer_Password;
	@Column(nullable = false)
	String customer_Role;
	@Column(nullable=false)
	String customer_Status;
	
	public String getCustomer_email() {
		return customer_Email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_Email = customer_email;
	}
	public String getCustomer_password() {
		return customer_Password;
	}
	public void setCustomer_password(String customer_password) {
		this.customer_Password = customer_password;
	}
	public String getCustomer_role() {
		return customer_Role;
	}
	public void setCustomer_role(String customer_role) {
		this.customer_Role = customer_role;
	}
	public String getCustomer_status() {
		return customer_Status;
	}
	public void setCustomer_status(String customer_status) {
		this.customer_Status = customer_status;
	}
	

}
