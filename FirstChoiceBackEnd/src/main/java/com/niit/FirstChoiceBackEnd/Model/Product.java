package com.niit.FirstChoiceBackEnd.Model;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;
 
@Entity
public class Product
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int product_Id;
	@Column( nullable = false, unique = true)
	@NotBlank(message = "Name cannot be Blank")
	@Length(min = 3, message ="Minimum No of Characters must be 3")
	String product_Name;
	@Column( nullable = false,columnDefinition = "TEXT")
	String product_Description;
	@Column( nullable = false)
	int product_Stock;
	@Column( nullable = false)
	float product_Price;
	@ManyToOne
	ProductCategory product_Category;
	
	@Transient
	MultipartFile product_Image;
	
	
	
	public MultipartFile getProduct_Image() {
		return product_Image;
	}
	public void setProduct_Image(MultipartFile product_Image) {
		this.product_Image = product_Image;
	}
	public int getProduct_Id() {
		return product_Id;
	}
	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_Description() {
		return product_Description;
	}
	public void setProduct_Description(String product_Description) {
		this.product_Description = product_Description;
	}
	public int getProduct_Stock() {
		return product_Stock;
	}
	public void setProduct_Stock(int product_Stock) {
		this.product_Stock = product_Stock;
	}
	public float getProduct_Price() {
		return product_Price;
	}
	public void setProduct_Price(float product_Price) {
		this.product_Price = product_Price;
	}
	public ProductCategory getProduct_Category() {
		return product_Category;
	}
	public void setProduct_Category(ProductCategory product_Category) {
		this.product_Category = product_Category;
	}
	
	
}
