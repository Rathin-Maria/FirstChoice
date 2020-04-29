package com.niit.FirstChoiceBackEnd.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductCategory
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int category_Id;
	@Column( nullable = false, unique = true)
	String category_Name;
	public int getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}
	public String getCategory_Name() {
		return category_Name;
	}
	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}
	
		

}
