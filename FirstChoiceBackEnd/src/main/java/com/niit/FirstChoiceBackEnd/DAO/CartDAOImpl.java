package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList; 

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FirstChoiceBackEnd.Model.Cart;
import com.niit.FirstChoiceBackEnd.Model.Customer;

@Repository("cart_dao") 
@Transactional 
public class CartDAOImpl implements ICartDAO

{

	@Autowired
	 SessionFactory sessionFactory;
	
	@Override
	public boolean addCart(Cart cart) 
	{
		 try
	       {
	        sessionFactory.getCurrentSession().save(cart);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public boolean updateCart(Cart cart)
	{
		 try
	       {
	        sessionFactory.getCurrentSession().update(cart);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public boolean deleteCart(Cart cart)
	{
		 try
	       {
	        sessionFactory.getCurrentSession().delete(cart);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public ArrayList<Cart> selectAllCart(Customer customer_Details)
	{
		 try
	      {
	        ArrayList<Cart> cart_list = (ArrayList<Cart>)sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("customer_Details",customer_Details)).list();
	        return cart_list;
	      }
	    catch(Exception e)
	     {
	      return null;
	     }
	}

	@Override
	public Cart selectOneCart(int cart_Id) 
	{
		try
	     {
	      Cart  cart = (Cart)sessionFactory.getCurrentSession().createCriteria (Cart.class).add(Restrictions.eq("cart_Id",cart_Id)).uniqueResult();
	      return cart;
	     }
	    catch(Exception e)
	    {
	    return null;
	    }
	}

}
