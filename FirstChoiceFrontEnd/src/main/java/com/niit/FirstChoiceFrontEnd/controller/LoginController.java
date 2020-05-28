package com.niit.FirstChoiceFrontEnd.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.FirstChoiceBackEnd.DAO.ICartDAO;
import com.niit.FirstChoiceBackEnd.DAO.ICustomerDAO;
import com.niit.FirstChoiceBackEnd.Model.Cart;
import com.niit.FirstChoiceBackEnd.Model.Customer;


@Controller
public class LoginController 
{
	
	@Autowired
	ICartDAO cart_dao;
	@Autowired
	ICustomerDAO customer_dao;

	@RequestMapping("/login")
	  String loginPage(@RequestParam(value = "error", required=false ) boolean error , Model model)
	  {
		if(error)
		{
			model.addAttribute("error1",true);	
			model.addAttribute("success",false);
			model.addAttribute("error2",false);
			model.addAttribute("message","Email or Password Incorrect");
		}
		else
		{
			model.addAttribute("error1",false);	
			model.addAttribute("success",false);
			model.addAttribute("error2",false);
		}
	    model.addAttribute("loginpage",true);
	    model.addAttribute("tittle","FirstChoice--login");
	    return "index";
	  }
	
	@RequestMapping("/loginsuccess")
	String loginSuccess(Model model, HttpSession session)
	{
		
		String user=SecurityContextHolder.getContext().getAuthentication().getName();
		//Collection<GrantedAuthority> roles= (Collection<GrantedAuthority> )SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		//Iterator<GrantedAuthority> role=roles.iterator();
		String  role= SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
         
		if(role.equals("[ROLE_ADMIN]"))
		{
			Customer customer = customer_dao.selectOneCustomer(user);
			session.setAttribute("username", customer.getCustomer_Name().toUpperCase());
			session.setAttribute("adminrole", true);
			session.setAttribute("userrole", false);
			
		}
		else
		{
			
			Customer customer = customer_dao.selectOneCustomer(user);
			session.setAttribute("custdetails", customer);
			session.setAttribute("username", customer.getCustomer_Name().toUpperCase());
			session.setAttribute("adminrole", false);
			session.setAttribute("userrole", true);
			ArrayList<Cart> cartlist= cart_dao.selectAllCart(customer);
			session.setAttribute("cartinfo", cartlist);
			session.setAttribute("cartqty", cartlist.size());
		
			if (session.getAttribute("prodid") != null)
			{
				int prodid=Integer.parseInt(session.getAttribute("prodid").toString());
			     int qty=Integer.parseInt(session.getAttribute("qty").toString());
			return "redirect:/addtocart?productid="+prodid+"&quantity="+qty;
			}
			
		}
		
		model.addAttribute("indexpage",true);
		return "index";
	
		
	}

}
