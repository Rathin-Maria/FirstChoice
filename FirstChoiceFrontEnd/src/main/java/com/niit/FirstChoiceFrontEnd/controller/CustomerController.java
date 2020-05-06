package com.niit.FirstChoiceFrontEnd.controller;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	   String Registered(@Valid @ModelAttribute("customerobject")Customer customer,BindingResult br,Model model)
		  {
		try
		{
		    	 if(br.hasErrors())
		    	 {
		    		
		 			model.addAttribute("customerobject", customer);
		 			model.addAttribute("error1",true);	
		 			model.addAttribute("success",false);
		 			model.addAttribute("error2",false);
		 			System.out.println("Errrrorrrr");
		 			
		    	 }
		    	 else
		    	 {
			       if(customer_dao.addCustomer(customer))
	                {
			    	  
						model.addAttribute("customerobject",new Customer());
						model.addAttribute("error1",false);	
						model.addAttribute("success", true);
						model.addAttribute("error2",false);
	                 }
	              else
	                {
	            	
	            	  model.addAttribute("customerobject", customer);
	  			   	model.addAttribute("error1",false);
	  				model.addAttribute("error2",true);	
	  				model.addAttribute("success",false);
	                 }
		    	 }
		      }
		   catch(Exception e)
		{
	
			   model.addAttribute("customerobject", customer);
			   	model.addAttribute("error1",false);
				model.addAttribute("error2",true);	
				model.addAttribute("success",false);
			   
		}
			
		    model.addAttribute("registerpage",true);
		    model.addAttribute("customerobject", customer);
		    model.addAttribute("tittle","FirstChoice--category");
		    return "index";
		  }
      	
}
