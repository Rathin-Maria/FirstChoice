package com.niit.FirstChoiceBackEnd.DAO;

import com.niit.FirstChoiceBackEnd.Model.Customer;

public interface ICustomerDAO
{

	  public boolean addCustomer(Customer customer);
	  public boolean updateCustomer(Customer customer);
	  public Customer selectOneCustomer(String email_Id);

}
