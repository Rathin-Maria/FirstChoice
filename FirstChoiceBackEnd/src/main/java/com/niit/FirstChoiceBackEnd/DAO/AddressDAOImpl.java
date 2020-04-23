package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FirstChoiceBackEnd.Model.Address;
import com.niit.FirstChoiceBackEnd.Model.Customer;

@Repository("address_dao") 
@Transactional 
public class AddressDAOImpl implements IAddressDAO 
{
	
	@Autowired
	 SessionFactory sessionFactory;

	@Override
	public boolean addAddress(Address address) 
	{
		try
    {
        sessionFactory.getCurrentSession().save(address);
        return true;
       }
       catch(Exception e1)
       {
         return false;
       }
	}

	@Override
	public boolean updateAddress(Address address) 
	{
		try
	    {
	        sessionFactory.getCurrentSession().update(address);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public boolean deleteAddress(Address address)
	{
		try
	    {
	        sessionFactory.getCurrentSession().delete(address);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	}

	@Override
	public ArrayList<Address> selectAllAddress(Customer customer_Details) 
	{
		   try
		      {
		        ArrayList<Address> address_list = (ArrayList<Address>)sessionFactory.getCurrentSession().createCriteria(Address.class).add(Restrictions.eq("customer_Details",customer_Details)).list();
		        return address_list;
		      }
		    catch(Exception e)
		     {
		      return null;
		     }
	}

	@Override
	public Address selectOneAddress(int address_Id)
	{
		 try
	     {
	      Address  address = (Address)sessionFactory.getCurrentSession().createCriteria (Address.class).add(Restrictions.eq("address_Id",address_Id)).uniqueResult();
	      return address;
	     }
	    catch(Exception e)
	    {
	    return null;
	    }
	}

}
