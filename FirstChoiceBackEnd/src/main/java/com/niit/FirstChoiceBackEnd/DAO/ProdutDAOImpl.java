package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList; 
import java.util.Locale.Category;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.niit.FirstChoiceBackEnd.Model.Product;

@Repository("product_dao") 
@Transactional 
public class ProdutDAOImpl implements IProductDAO 
{

	@Autowired
	 SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product product) 
	{
		try
	    {
	        sessionFactory.getCurrentSession().save(product);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public boolean updateProduct(Product product)
	{
		try
	    {
	        sessionFactory.getCurrentSession().update(product);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public boolean deleteProduct(Product product)
	{
		try
	    {
	        sessionFactory.getCurrentSession().delete(product);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public ArrayList<Product> selectAllProduct()
	{
		try
	      {
	        ArrayList<Product> product_list = (ArrayList<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).list();
	        return product_list;
	      }
	    catch(Exception e)
	     {
	      return null;
	     }
	}

	@Override
	public Product selectOneProduct(int product_Id) 
	{
		try
	     {
	      Product  product = (Product)sessionFactory.getCurrentSession().createCriteria (Product.class).add(Restrictions.eq("product_Id",product_Id)).uniqueResult();
	      return product;
	     }
	    catch(Exception e)
	    {
	    return null;
	    }
	}

	@Override
	public ArrayList<Product> allProductByCategory(Category product_Category) 
	{
		  try
	      {
	        ArrayList<Product> product_list = (ArrayList<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("product_Category",product_Category)).list();
	        return product_list;
	      }
	    catch(Exception e)
	     {
	      return null;
	     }
	}

}
