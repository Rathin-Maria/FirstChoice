package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.niit.FirstChoiceBackEnd.Model.Customer;

@Repository("order_dao") 
@Transactional 
public class OrderDAOImpl implements IOrderDAO {

	@Autowired
	 SessionFactory sessionFactory;
	
	@Override
	public boolean addOrder(Order order)
	{
		try
	    {
	        sessionFactory.getCurrentSession().save(order);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public boolean updateOrder(Order order) 
	{
		try
	    {
	        sessionFactory.getCurrentSession().update(order);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public boolean deleteOrder(Order order) 
	{
		try
	    {
	        sessionFactory.getCurrentSession().delete(order);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public ArrayList<Order> selectAllOrder(Customer customer_Details)
	{
		 try
	      {
	        ArrayList<Order> order_list = (ArrayList<Order>)sessionFactory.getCurrentSession().createCriteria(Order.class).add(Restrictions.eq("customer_Details",customer_Details)).list();
	        return order_list;
	      }
	    catch(Exception e)
	     {
	      return null;
	     }
		
	}

	@Override
	public Order selectOneOrder(String order_Id) 
	{
		 try
	     {
	      Order  order = (Order)sessionFactory.getCurrentSession().createCriteria (Order.class).add(Restrictions.eq("order_Id",order_Id)).uniqueResult();
	      return order;
	     }
	    catch(Exception e)
	    {
	    return null;
	    }
	}

}
