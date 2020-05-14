package com.niit.FirstChoiceFrontEnd.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.FirstChoiceBackEnd.DAO.ICustomerDAO;
import com.niit.FirstChoiceBackEnd.Model.Customer;


@Controller
public class LoginController 
{
	
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
			session.setAttribute("username", user.toUpperCase());
			session.setAttribute("adminrole", true);
			
		}
		else
		{
			
			Customer customer = customer_dao.selectOneCustomer(user);
			session.setAttribute("username", customer.getCustomer_Name().toUpperCase());
			session.setAttribute("adminrole", false);
			session.setAttribute("userrole", true);
		}
		
		return "index";
	
		
	}

}
