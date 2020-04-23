package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList;

import com.niit.FirstChoiceBackEnd.Model.Cart;
import com.niit.FirstChoiceBackEnd.Model.Customer;

public interface ICartDAO 
{
	public boolean addCart(Cart cart);
   public boolean updateCart(Cart cart);
   public boolean deleteCart(Cart cart);
   public ArrayList<Cart> selectAllCart(Customer customer);
   public Cart selectOneCart(int cart_Id);
}
