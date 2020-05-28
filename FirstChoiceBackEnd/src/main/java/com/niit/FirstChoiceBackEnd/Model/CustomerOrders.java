package com.niit.FirstChoiceBackEnd.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerOrders 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int dummy_Id;
	@Column(nullable = false)
	String order_Id;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	Date order_Date;
	@ManyToOne
	Product product_Details;
	@ManyToOne
	Customer customer_Details;
	@ManyToOne
	Address customer_Address;
	@Column(nullable = false)
	float order_Total;
	@Column(nullable = false)
	int product_Quantity;
	public int getDummy_Id() {
		return dummy_Id;
	}
	public void setDummy_Id(int dummy_Id) {
		this.dummy_Id = dummy_Id;
	}
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
	public int getProduct_Quantity() {
		return product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}

	
}
