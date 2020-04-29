package com.niit.FirstChoiceFrontEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.niit.FirstChoiceBackEnd.DAO.ICustomerDAO;
import com.niit.FirstChoiceBackEnd.Model.Customer;

@Controller
public class CustomerController 
{

	@Autowired
	ICustomerDAO customer_dao;
	
	
		@RequestMapping("/register")

		  String RegisterPage(Model model)
		  {
			  model.addAttribute("registerpage",true);
			  model.addAttribute("customerobject",new Customer());
			  model.addAttribute("tittle","FirstChoice--register");
		       return "index";
		  }
		
		@RequestMapping("/registered")	
	   String addCategoryPage(@ModelAttribute("customerobject") Customer customer,Model model)
		  {
		try
		{
			if(customer_dao.addCustomer(customer))
	        {
	            model.addAttribute("info",true);
	            model.addAttribute("message","Sucessfully Registered"); 
	            System.out.println("Done");
	        }
	        else
	        {
	          model.addAttribute("info",true);
	          model.addAttribute("message","Invalid Data");
	          System.out.println("Faliure");
	        }
		}
		
		catch(Exception e1)
		{
			 model.addAttribute("info",true);
	          model.addAttribute("message","Invalid Data");
	          System.out.println("Faliure");
			
		}
			
			   model.addAttribute("registerpage",true);
			  model.addAttribute("customerobject",new Customer());
			  model.addAttribute("tittle","FirstChoice--register");
		       return "index";
		  }
		
}
