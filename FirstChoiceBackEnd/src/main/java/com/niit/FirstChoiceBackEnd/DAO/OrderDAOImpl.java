package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.niit.FirstChoiceBackEnd.Model.Customer;
import com.niit.FirstChoiceBackEnd.Model.CustomerOrders;

@Repository("order_dao") 
@Transactional 
public class OrderDAOImpl implements IOrderDAO {

	@Autowired
	 SessionFactory sessionFactory;
	
	@Override
	public boolean addOrder(CustomerOrders order)
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
	public boolean updateOrder(CustomerOrders order)
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
	public boolean deleteOrder(CustomerOrders order)
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
	public ArrayList<CustomerOrders> selectAllOrder(Customer customer_Details)
	{
		 try
	      {
	        ArrayList<CustomerOrders> order_list = (ArrayList<CustomerOrders>) sessionFactory.getCurrentSession().createCriteria(CustomerOrders.class).add(Restrictions.eq("customer_Details",customer_Details)).list();
	        return order_list;
	      }
	    catch(Exception e)
	     {
	      return null;
	     }
		
	}

	@Override
	public ArrayList<CustomerOrders>  selectOneOrder(String order_Id) 
	{
		 try
	     {
		  ArrayList<CustomerOrders> order = (ArrayList<CustomerOrders>)sessionFactory.getCurrentSession().createCriteria (CustomerOrders.class).add(Restrictions.eq("order_Id",order_Id)).list();
	      return order;
	     }
	    catch(Exception e)
	    {
	    return null;
	    }
	}


}
