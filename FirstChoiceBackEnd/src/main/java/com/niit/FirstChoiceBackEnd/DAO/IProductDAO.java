package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList; 
import java.util.Locale.Category;

import com.niit.FirstChoiceBackEnd.Model.Product;

public interface IProductDAO 
{
	public boolean addProduct(Product product);
    public boolean updateProduct(Product product);
	public boolean deleteProduct(Product product);
	 public ArrayList<Product> selectAllProduct();
	public Product selectOneProduct(int product_Id);
	public ArrayList<Product>allProductByCategory(Category category);
}
