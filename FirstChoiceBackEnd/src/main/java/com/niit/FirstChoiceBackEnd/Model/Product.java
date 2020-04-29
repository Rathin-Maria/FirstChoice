package com.niit.FirstChoiceBackEnd.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int product_Id;
	@Column( nullable = false, unique = true)
	String product_Name;
	@Column( nullable = false,columnDefinition = "TEXT")
	String product_Description;
	@Column( nullable = false)
	int product_Stock;
	@Column( nullable = false)
    float product_Price;
	@ManyToOne
	ProductCategory product_Category;
	
	public int getProduct_id() {
		return product_Id;
	}
	public void setProduct_id(int product_id) {
		this.product_Id = product_id;
	}
	public String getProduct_name() {
		return product_Name;
	}
	public void setProduct_name(String product_name) {
		this.product_Name = product_name;
	}
	public String getProduct_description() {
		return product_Description;
	}
	public void setProduct_description(String product_description) {
		this.product_Description = product_description;
	}
	public int getProduct_stock() {
		return product_Stock;
	}
	public void setProduct_stock(int product_stock) {
		this.product_Stock = product_stock;
	}
	public float getProduct_price() {
		return product_Price;
	}
	public void setProduct_price(float product_price) {
		this.product_Price = product_price;
	}
	public ProductCategory getProduct_category() {
		return product_Category;
	}
	public void setProduct_category(ProductCategory product_category) {
		this.product_Category = product_category;
	}
	
}
