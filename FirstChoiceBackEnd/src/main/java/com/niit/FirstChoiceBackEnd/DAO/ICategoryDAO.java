package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList; 

import com.niit.FirstChoiceBackEnd.Model.ProductCategory;

public interface ICategoryDAO
{
	public boolean addCategory(ProductCategory category);
	public boolean updateCategory(ProductCategory category);
	public boolean deleteCategory(ProductCategory category);
	public ArrayList<ProductCategory> selectAllCategory();
	public ProductCategory selectOneCategory(String category_Name);
}
