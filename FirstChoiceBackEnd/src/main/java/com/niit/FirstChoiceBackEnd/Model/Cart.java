package com.niit.FirstChoiceBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cart
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cart_Id;
	@Column(nullable=false)
	int product_Quantity;
	@ManyToOne
	Customer customer_Details;
	@ManyToOne
	Product product_Details;
	public int getCart_Id() {
		return cart_Id;
	}
	public void setCart_Id(int cart_Id) {
		this.cart_Id = cart_Id;
	}
	public int getProduct_Quantity() {
		return product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		this.product_Quantity = product_Quantity;
	}
	public Customer getCustomer_Details() {
		return customer_Details;
	}
	public void setCustomer_Details(Customer customer_Details) {
		this.customer_Details = customer_Details;
	}
	public Product getProduct_Details() {
		return product_Details;
	}
	public void setProduct_Details(Product product_Details) {
		this.product_Details = product_Details;
	}
	
	

	
}
