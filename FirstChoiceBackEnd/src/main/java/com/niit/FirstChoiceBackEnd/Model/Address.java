package com.niit.FirstChoiceBackEnd.Model;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Address
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int address_Id;
	
	@Column(nullable = false)
	String customer_Name;
	
	@Column(nullable = false, unique = true)
	String customer_PhoneNo;
	
	@Column( nullable = false,columnDefinition = "TEXT")
	String address_Area;
	
	@Column(nullable = false)
	String address_State;
	
	@Column(nullable = false)
	String address_Country;
	
	@Column(nullable = false)
	String address_Type;
	
	@Column(nullable = false)
    int address_Pincode;
	
	@ManyToOne
	Customer customer_Details;

	public int getAddress_Id() {
		return address_Id;
	}

	public void setAddress_Id(int address_Id) {
		this.address_Id = address_Id;
	}

	public String getCustomer_Name() {
		return customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}

	public String getCustomer_PhoneNo() {
		return customer_PhoneNo;
	}

	public void setCustomer_PhoneNo(String customer_PhoneNo) {
		this.customer_PhoneNo = customer_PhoneNo;
	}

	public String getAddress_Area() {
		return address_Area;
	}

	public void setAddress_Area(String address_Area) {
		this.address_Area = address_Area;
	}

	public String getAddress_State() {
		return address_State;
	}

	public void setAddress_State(String address_State) {
		this.address_State = address_State;
	}

	public String getAddress_Country() {
		return address_Country;
	}

	public void setAddress_Country(String address_Country) {
		this.address_Country = address_Country;
	}

	public String getAddress_Type() {
		return address_Type;
	}

	public void setAddress_Type(String address_Type) {
		this.address_Type = address_Type;
	}

	public int getAddress_Pincode() {
		return address_Pincode;
	}

	public void setAddress_Pincode(int address_Pincode) {
		this.address_Pincode = address_Pincode;
	}

	public Customer getCustomer_Details() {
		return customer_Details;
	}

	public void setCustomer_Details(Customer customer_Details) {
		this.customer_Details = customer_Details;
	}

	
	
}
