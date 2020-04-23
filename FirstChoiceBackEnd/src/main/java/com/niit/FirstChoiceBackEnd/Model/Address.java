package com.niit.FirstChoiceBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Address
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int address_Id;
	@Column(nullable = false)
	String customer_Name;
	@Column(nullable = false)
	String address_Line1;
	@Column(nullable = false)
	String address_Line2;
	@Column(nullable = false)
	String address_Area;
	@Column(nullable = false)
    int address_Pincode;
	@Column(nullable = false)
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
	public String getAddress_Line1() {
		return address_Line1;
	}
	public void setAddress_Line1(String address_Line1) {
		this.address_Line1 = address_Line1;
	}
	public String getAddress_Line2() {
		return address_Line2;
	}
	public void setAddress_Line2(String address_Line2) {
		this.address_Line2 = address_Line2;
	}
	public String getAddress_Area() {
		return address_Area;
	}
	public void setAddress_Area(String address_Area) {
		this.address_Area = address_Area;
	}
	public int getAddress_Pincode() {
		return address_Pincode;
	}
	public void setAddress_Pincode(int address_Pincode) {
		this.address_Pincode = address_Pincode;
	}
	public Customer getCustomer_details() {
		return customer_Details;
	}
	public void setCustomer_details(Customer customer_details) {
		this.customer_Details = customer_details;
	}
	
	
}
