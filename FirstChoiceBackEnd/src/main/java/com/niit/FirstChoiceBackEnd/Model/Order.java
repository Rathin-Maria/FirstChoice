package com.niit.FirstChoiceBackEnd.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Order 
{
	@Id
	@Column(nullable = false,unique =true)
	String order_Id;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	Date order_Date;
	@Column(nullable = false)
	Product product_Details;
	@Column(nullable = false)
	Customer customer_Details;
	@Column(nullable = false)
	Address customer_Address;
	@Column(nullable = false)
	float order_Total;
	
	public String getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}
	
	public Date getOrder_Date() {
		return order_Date;
	}
	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}
	
	public Product getProduct_Details() {
		return product_Details;
	}
	public void setProduct_Details(Product product_Details) {
		this.product_Details = product_Details;
	}
	public Customer getCustomer_Details() {
		return customer_Details;
	}
	public void setCustomer_Details(Customer customer_Details) {
		this.customer_Details = customer_Details;
	}
	public Address getCustomer_Address() {
		return customer_Address;
	}
	public void setCustomer_Address(Address customer_Address) {
		this.customer_Address = customer_Address;
	}
	public float getOrder_Total() {
		return order_Total;
	}
	public void setOrder_Total(float order_Total) {
		this.order_Total = order_Total;
	}
	
	
}
