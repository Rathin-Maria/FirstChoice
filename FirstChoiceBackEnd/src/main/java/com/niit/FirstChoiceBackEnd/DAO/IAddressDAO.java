package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList;

import com.niit.FirstChoiceBackEnd.Model.Address;
import com.niit.FirstChoiceBackEnd.Model.Customer;

public interface IAddressDAO 
{
	
	boolean addAddress(Address address);
    public boolean updateAddress(Address address);
	public boolean deleteAddress(Address address);
	 public ArrayList<Address> selectAllAddress(Customer customer);
	Address selectOneAddress(int address_Id);

}
