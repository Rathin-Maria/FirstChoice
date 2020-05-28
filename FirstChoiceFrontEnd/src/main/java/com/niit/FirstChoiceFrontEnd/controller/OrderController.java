package com.niit.FirstChoiceFrontEnd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.FirstChoiceBackEnd.DAO.IAddressDAO;
import com.niit.FirstChoiceBackEnd.DAO.ICartDAO;
import com.niit.FirstChoiceBackEnd.DAO.IOrderDAO;
import com.niit.FirstChoiceBackEnd.DAO.IProductDAO;
import com.niit.FirstChoiceBackEnd.Model.Address;
import com.niit.FirstChoiceBackEnd.Model.Cart;
import com.niit.FirstChoiceBackEnd.Model.Customer;
import com.niit.FirstChoiceBackEnd.Model.CustomerOrders;
import com.niit.FirstChoiceBackEnd.Model.Product;

@Controller


@RequestMapping("/user")
public class OrderController 
{
	static String  orderid = "OD"; 

	
	@Autowired
	IAddressDAO address_dao;
	
	@Autowired
	IOrderDAO order_dao;
	
	@Autowired
	ICartDAO cart_dao;
    
	@Autowired
	IProductDAO product_dao;
	
	@RequestMapping("/placeorder")
	String addToCart(@RequestParam("addressid") int addressid,Model model,HttpSession session)
	{
		String orderid="OD" +UUID.randomUUID().getMostSignificantBits();
		ArrayList<Cart> cartlist = (ArrayList<Cart>)session.getAttribute("cartinfo");
		Address address =  address_dao.selectOneAddress(addressid);
		Customer customer = (Customer)session.getAttribute("custdetails");
		float total = Float.parseFloat(session.getAttribute("Total").toString());
		CustomerOrders order =  new CustomerOrders();
		
		Iterator<Cart> cartitem = cartlist.listIterator();
		
		while(cartitem.hasNext())
		{
	    Cart item = (Cart) cartitem.next();
	    
		order.setCustomer_Address(address);
		order.setCustomer_Details(customer);
		order.setOrder_Date(new Date());
		order.setOrder_Total(total);
		order.setOrder_Id(orderid);
		order.setProduct_Details(item.getProduct_Details());
		order.setProduct_Quantity(item.getProduct_Quantity());
		
		Product product = item.getProduct_Details();
		if(product.getProduct_Stock() >= item.getProduct_Quantity()  && order_dao.addOrder(order))
		{
			product.setProduct_Stock(product.getProduct_Stock() - item.getProduct_Quantity());
			product_dao.updateProduct(product);
			cart_dao.deleteCart(item);
		}
			
	 }
		return "index";
	}
	
	
	@RequestMapping("/viewallorders")
	String viewOrders(HttpSession session,Model model)
	{
		Customer customer = (Customer)session.getAttribute("custdetails");
		ArrayList<CustomerOrders> orders = order_dao.selectAllOrder(customer);
		ArrayList<ArrayList<CustomerOrders>> ordersPerId = new ArrayList<ArrayList<CustomerOrders>>();
		Iterator<CustomerOrders> odlist = orders.listIterator();
		while(odlist.hasNext())
		{
			
			CustomerOrders order = (CustomerOrders) odlist.next();

		    System.out.println(order.getOrder_Id());
			System.out.println(orderid);
			System.out.println("------------------");
			if( !order.getOrder_Id().equals(orderid))
			{
				ordersPerId.add(order_dao.selectOneOrder(order.getOrder_Id()));
				System.out.println("Success");
				OrderController.orderid = order.getOrder_Id();
			}
			
										
		}
		
        Iterator<ArrayList<CustomerOrders>> a =  ordersPerId.listIterator();		
		while(a.hasNext())
		{
			ArrayList<CustomerOrders> item = (ArrayList<CustomerOrders>) a.next();
			Iterator<CustomerOrders> b =  item.listIterator();		
			while(b.hasNext())
			{
				CustomerOrders od = (CustomerOrders) b.next();
				System.out.println(od.getOrder_Id());
			}
			
		}
		System.out.println(ordersPerId);
	     model.addAttribute("orderPerId", ordersPerId);
		model.addAttribute("orderpage", true);
		return "index";
		
	}
	
}
