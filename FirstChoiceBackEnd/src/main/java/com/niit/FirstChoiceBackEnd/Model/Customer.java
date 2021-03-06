package com.niit.FirstChoiceBackEnd.Model;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Customer 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int customer_Id;
	
	@Column(nullable = false)
	@NotBlank(message = "Name cannot be Blank")
	String customer_Name;
	
	@Column(nullable = false, unique = true)
	@Email( message="Email Format must be aaaa@gg.com")
	String customer_Email;
	
	@Column(nullable = false, unique = true)
	@Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[6-9]\\d{9}$", message="Mobile no. must be of Indian Standards {+91}-9000000001")
	String customer_PhoneNo;
	
	@Transient
	@Column(nullable=false)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\W)[a-zA-Z0-9\\S]{7,}$", message="Password must atleast contain one special character,uppercase,lowercase and numbers")
	String  customer_Password;
	
	public int getCustomer_Id() {
		return customer_Id;
	}
	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	public String getCustomer_Email() {
		return customer_Email;
	}
	public void setCustomer_Email(String customer_Email) {
		this.customer_Email = customer_Email;
	}
	public String getCustomer_PhoneNo() {
		return customer_PhoneNo;
	}
	public void setCustomer_PhoneNo(String customer_PhoneNo) {
		this.customer_PhoneNo = customer_PhoneNo;
	}
	public String getCustomer_Password() {
		return customer_Password;
	}
	public void setCustomer_Password(String customer_Password) {
		this.customer_Password = customer_Password;
	}
		

	
}
