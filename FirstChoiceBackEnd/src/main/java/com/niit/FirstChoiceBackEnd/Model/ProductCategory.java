package com.niit.FirstChoiceBackEnd.Model;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ProductCategory
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int category_Id;
	@Column( nullable = false, unique = true)
	String category_Name;
	
	public int getCategory_id() {
		return category_Id;
	}
	public void setCategory_id(int category_id) {
		this.category_Id = category_id;
	}
	public String getCategory_name() {
		return category_Name;
	}
	public void setCategory_name(String category_name) {
		this.category_Name = category_name;
	}
	
	

}
