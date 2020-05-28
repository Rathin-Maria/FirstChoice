package com.niit.FirstChoiceBackEnd.DAO;

import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.niit.FirstChoiceBackEnd.Model.Customer;
import com.niit.FirstChoiceBackEnd.Model.CustomerOrders;

public interface IOrderDAO 
{
	public boolean  addOrder(CustomerOrders order);
    public boolean updateOrder(CustomerOrders order);
	public boolean deleteOrder ( CustomerOrders order);
	public ArrayList<CustomerOrders> selectAllOrder(Customer customer);
	public ArrayList<CustomerOrders> selectOneOrder(String order_Id);
}
