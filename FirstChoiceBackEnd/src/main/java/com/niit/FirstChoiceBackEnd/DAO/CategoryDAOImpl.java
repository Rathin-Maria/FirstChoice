package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList;  

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FirstChoiceBackEnd.Model.ProductCategory;

@Repository("category_dao") 
@Transactional 
public class CategoryDAOImpl implements ICategoryDAO 
{

	@Autowired
	 SessionFactory sessionFactory;
	
	@Override
	public boolean addCategory(ProductCategory category)
	{
		  try
	       {
	        sessionFactory.getCurrentSession().save(category);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public boolean updateCategory(ProductCategory category) 
	{
		  try
	      {
	        sessionFactory.getCurrentSession().update(category);
	        return true;
	      }
	     catch(Exception e1)
	     {
	       return false;
	     }
	}

	@Override
	public boolean deleteCategory(ProductCategory category)
	{
		  try
	      {
	        sessionFactory.getCurrentSession().delete(category);
	        return true;
	      }
	     catch(Exception e1)
	     {
	       return false;
	     }
	}

	@Override
	public ArrayList<ProductCategory> selectAllCategory()
	{
		     try
		      {
		        ArrayList<ProductCategory> category_list = (ArrayList<ProductCategory>)sessionFactory.getCurrentSession().createQuery("from ProductCategory").list();
		        
		        return category_list;
		      }
		    catch(Exception e)
		     {
		      return null;
		     }
	}

	@Override
	public ProductCategory selectOneCategory(String category_Name)
	{
		 try
	     {
	       ProductCategory category= (ProductCategory)sessionFactory.getCurrentSession().createCriteria (ProductCategory.class).add(Restrictions.eq("category_Name",category_Name)).uniqueResult();
	      return category;
	     }
	    catch(Exception e)
	    {
	    return null;
	    }
}
}