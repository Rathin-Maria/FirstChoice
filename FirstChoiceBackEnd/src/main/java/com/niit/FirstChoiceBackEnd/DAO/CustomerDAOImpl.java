package com.niit.FirstChoiceBackEnd.DAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.FirstChoiceBackEnd.Model.Customer;
import com.niit.FirstChoiceBackEnd.Model.CustomerCredentials;

@Repository("customer_dao") 
@Transactional 
public class CustomerDAOImpl  implements ICustomerDAO
{

	@Autowired
	   SessionFactory sessionFactory;
	   
	   public boolean addCustomer(Customer customer)
	   {
	       try
	       {
	        sessionFactory.getCurrentSession().save(customer);
	        CustomerCredentials credential = new CustomerCredentials();
	        credential.setCustomer_email(customer.getCustomer_Email());
	        credential.setCustomer_password(customer.getCustomer_Password());
	        credential.setCustomer_status("false");
	        credential.setCustomer_role("ROLE_CUSTOMER");
	        sessionFactory.getCurrentSession().save(credential);
	        return true;
	       }
	       catch(Exception e1)
	       {
	         return false;
	       }
	   }

	   public boolean updateCustomer(Customer customer)
	   {
	       try
	      {
	        sessionFactory.getCurrentSession().update(customer);
	        return true;
	      }
	     catch(Exception e1)
	     {
	       return false;
	     }
	   }
	   
	  


	  public Customer  selectOneCustomer(String customer_Email)
	  {
	    try
	     {
	      Customer customer= (Customer)sessionFactory.getCurrentSession().createCriteria (Customer.class).add(Restrictions.eq("customer_Email",customer_Email)).uniqueResult();
	      return customer;
	     }
	    catch(Exception e)
	    {
	    return null;
	    }
	  } 


}
