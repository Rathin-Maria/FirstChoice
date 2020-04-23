package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.niit.FirstChoiceBackEnd.Model.Customer;

public interface IOrderDAO 
{
	public boolean  addOrder(Order order);
    public boolean updateOrder(Order order);
	public boolean deleteOrder(Order order);
	public ArrayList<Order> selectAllOrder(Customer customer);
	public Order selectOneOrder(String order_Id);
}
