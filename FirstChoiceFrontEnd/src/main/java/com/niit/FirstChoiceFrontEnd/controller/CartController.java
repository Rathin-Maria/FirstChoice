package com.niit.FirstChoiceFrontEnd.controller;

import java.util.ArrayList; 
import java.util.Iterator;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.FirstChoiceBackEnd.DAO.ICartDAO;
import com.niit.FirstChoiceBackEnd.DAO.IProductDAO;
import com.niit.FirstChoiceBackEnd.Model.Cart;
import com.niit.FirstChoiceBackEnd.Model.Customer;
import com.niit.FirstChoiceBackEnd.Model.Product;

@Controller
public class CartController 
{

	@Autowired
	IProductDAO product_dao;
	
	@Autowired
	ICartDAO  cart_dao;
	
	@RequestMapping("/addtocart")
	String addToCart(@RequestParam("productid") int prodid,@RequestParam(required=false ,value="quantity",defaultValue = "1") int qty,@RequestParam(required=false ,value="cartstatus",defaultValue = "false") boolean cartstatus ,Model model,HttpSession session)
	{
		Customer customer = (Customer)session.getAttribute("custdetails");
		System.out.println(prodid);
		System.out.println(qty);
		
		if(session.getAttribute("cartinfo")==null)
		{
			session.setAttribute("prodid", prodid);
			session.setAttribute("qty", qty);
		    model.addAttribute("loginpage",true);
		}
		
		else
		{
			
			Cart item = new Cart();			
			Product product = product_dao.selectOneProduct(prodid);
			ArrayList<Cart> cartlist =(ArrayList<Cart>)session.getAttribute("cartinfo");
			
			if(cartlist.isEmpty())
			{
			addInCart(item,customer, product, qty, model);
			}
			
			else
			{
			      boolean ifExists=false;   
			     ifExists = updateInCart(cartlist, cartstatus, prodid,product, qty, model,session);
			    if(!ifExists)
				{
					addInCart(item,customer, product, qty, model);
				}
			    
			}
			
			session.setAttribute("cartinfo", cart_dao.selectAllCart(customer));
			session.setAttribute("cartqty", cart_dao.selectAllCart(customer).size());
			setFees(customer,session);
			model.addAttribute("cartpage",true);
			
		}	
		return "index";
	}
	
	@RequestMapping("/user/viewcart")
	String viewCart(HttpSession session, Model model)
   {
		Customer customer = (Customer)session.getAttribute("custdetails");
		if(session.getAttribute("cartinfo")== null)
		{
		session.setAttribute("cartinfo", cart_dao.selectAllCart(customer));	
		}
		setFees(customer,session);
		model.addAttribute("cartpage",true);
		return "index";
    }
	
	@RequestMapping("/deletefromcart")
	String viewCart(@RequestParam("cartid") int cartid, Model model,HttpSession session)
   {
		
		Customer customer = (Customer)session.getAttribute("custdetails");
		cart_dao.deleteCart(cart_dao.selectOneCart(cartid));
		setFees(customer,session);
		session.setAttribute("cartinfo", cart_dao.selectAllCart(customer));
		session.setAttribute("cartqty", cart_dao.selectAllCart(customer).size());
		model.addAttribute("cartpage",true);
		return "index";
    }
	
	void createCart(Product product, int  qty, Cart item , Model model) 
	{
		  if(qty > 5)
          {
			  model.addAttribute("prodid", product.getProduct_Id());
          	model.addAttribute("error2", true);
		    model.addAttribute("message","Max of 5 pieces only is allowed for a Customer");	
          }
          else if(product.getProduct_Stock()>= qty && qty>0)
			{
				item.setProduct_Quantity(qty);
				
			}
			else if(qty == 0)
			{
				model.addAttribute("prodid", product.getProduct_Id());
				model.addAttribute("error1", true);
				model.addAttribute("message","Product Quantity cannot be less than One");	
			}
			else
			{
				model.addAttribute("prodid", product.getProduct_Id());
				model.addAttribute("error1", true);
				model.addAttribute("message","Stock Not Available");					
			}
  }
	
	void incrementCart(Product product, int  qty, Cart item , Model model) 
	{
		int oldqty = item.getProduct_Quantity();
	    int newqty = oldqty +qty;
	                        if(newqty > 5)
	                        {
	                        	model.addAttribute("prodid", product.getProduct_Id());
	                        	model.addAttribute("error2", true);
								model.addAttribute("message","Max of 5 pieces only is allowed for a Customer");	
	                        }
	                        else if(product.getProduct_Stock()>= newqty && newqty>0)
							{
								item.setProduct_Quantity(newqty);
								
							}
							else if(newqty == 0)
							{
								model.addAttribute("prodid", product.getProduct_Id());
								model.addAttribute("error1", true);
								model.addAttribute("message","Product Quantity cannot be less than One");	
							}
							else
							{
								model.addAttribute("prodid", product.getProduct_Id());
								model.addAttribute("error1", true);
								model.addAttribute("message","Stock Not Available");					
							}
      }	
	
    boolean updateInCart(ArrayList<Cart> cartlist , boolean cartstatus, int prodid,Product product, int  qty, Model model,HttpSession session)
    {
    boolean ifExists = false;
	Iterator<Cart> cartitem = cartlist.listIterator();
	while(cartitem.hasNext())
	{
	Cart item1 = (Cart) cartitem.next();
	if(item1.getProduct_Details().getProduct_Id()==prodid)
    	{
		if(cartstatus)
		{
			createCart(product, qty, item1, model);
			cart_dao.updateCart(item1);
			ifExists=  true;
			break;
		}
		 else
		 {
	    	incrementCart(product, qty, item1 , model); 
		    cart_dao.updateCart(item1);
		    ifExists=  true;
		    break;
	      }
	    }
	 }
	return ifExists;
  }
    
    void addInCart(Cart item,Customer customer,Product product,int  qty, Model model)
    {
    	item.setCustomer_Details(customer);
		item.setProduct_Details(product);
		createCart(product, qty, item, model);
		cart_dao.addCart(item);
    	
    }
    
   void setFees(Customer customer,HttpSession session)
    {
    	float price = 0;
    	float total=0;
    	int shippingfee;
    	ArrayList<Cart> cartlist =cart_dao.selectAllCart(customer);
    	Iterator<Cart> cartitem = cartlist.listIterator();
    	while(cartitem.hasNext())
    	{
    		Cart item = (Cart) cartitem.next();
    		price = price +( item.getProduct_Quantity() * item.getProduct_Details().getProduct_Price());
    		price= (float) ((float)Math.round(price * 100.0) / 100.0) ;
         }
    	
    if(price >= 1000)
    {
    	shippingfee=0;
    }
    else if(price >= 500)
    {
    	shippingfee= 25;
    }
    else
    {
    	shippingfee= 50;
    }
    
    total = price + shippingfee;
    
    session.setAttribute("Price", price);
    session.setAttribute("ShippingFee", shippingfee);
    session.setAttribute("Total", total);
    
   }
    	
    
    
}
