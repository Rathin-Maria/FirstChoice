package com.niit.FirstChoiceFrontEnd.controller;

import java.util.Map;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.FirstChoiceBackEnd.DAO.IAddressDAO;
import com.niit.FirstChoiceBackEnd.Model.Address;
import com.niit.FirstChoiceBackEnd.Model.Customer;

@Controller
@RequestMapping("/user")
public class AddressController
{
	
	@Autowired
	IAddressDAO address_dao;
	
	@RequestMapping("/selectaddress")
	String addressPage(Model model,HttpSession session)
	{
		Customer customer =(Customer)session.getAttribute("custdetails");
		model.addAttribute("addresspage", true );
		model.addAttribute("addresslist", address_dao.selectAllAddress(customer));
		return "index" ;
	}
	
	
	@RequestMapping("/addaddress")	
	   String addAddressPage(@RequestParam  Map<String, String> addressmodel  ,Model model, HttpSession session)
		  {
		Customer customer = (Customer)session.getAttribute("custdetails");
	    Address address = new Address();
	    address.setCustomer_Details(customer);
		address.setCustomer_Name(addressmodel.get("customer_name"));
		address.setCustomer_PhoneNo(addressmodel.get("customer_phnno"));
		address.setAddress_Area(addressmodel.get("address_area"));
		address.setAddress_State(addressmodel.get("address_state"));
		address.setAddress_Country(addressmodel.get("address_country"));
		address.setAddress_Pincode(Integer.parseInt(addressmodel.get("address_pincode")));
		address.setAddress_Type(addressmodel.get("address_type"));
		
		try
		{
		    	 
			       if(address_dao.addAddress(address))
	                {
			    	  
						model.addAttribute("error1",false);	
						model.addAttribute("success", true);
						model.addAttribute("error2",false);
						model.addAttribute("message","Address Successfully Added");
	                 }
	              else
	                {
	            	
	  			   	model.addAttribute("error1",false);
	  				model.addAttribute("error2",true);	
	  				model.addAttribute("success",false);
	  				model.addAttribute("message","Address Already Exist");
	                 }
		    	 }
		
		   catch(Exception e)
		{
	
			   	model.addAttribute("error1",false);
				model.addAttribute("error2",true);	
				model.addAttribute("success",false);
				model.addAttribute("message","Address Already Exist");
			   
		}
			
		     model.addAttribute("addresspage", true );
		     model.addAttribute("addresslist", address_dao.selectAllAddress(customer));
		  
		    return "index";
    }
	
	@RequestMapping("/getaddresstoedit")
	String getAddressToEdit(@RequestParam("addressid") int address_id , Model model)
	{
		
		model.addAttribute("error1",false);	
		model.addAttribute("success", false);
		model.addAttribute("error2",false);
		 model.addAttribute("editaddresspage",true);
		model.addAttribute("addressobject",address_dao.selectOneAddress(address_id));
	    model.addAttribute("tittle","FirstChoice--EditAddress");
	    return "index";
	
	}

	@RequestMapping("/updateaddress")	
	   String addProductPage(@RequestParam  Map<String, String> addressmodel  ,Model model, HttpSession session)
		  {
		Customer customer = (Customer)session.getAttribute("custdetails");
		System.out.println(customer.getCustomer_Name());
	    Address address = new Address();
	    address.setCustomer_Details(customer);
		address.setCustomer_Name(addressmodel.get("customer_name"));
		address.setCustomer_PhoneNo(addressmodel.get("customer_phnno"));
		address.setAddress_Area(addressmodel.get("address_area"));
		address.setAddress_State(addressmodel.get("address_state"));
		address.setAddress_Country(addressmodel.get("address_country"));
		address.setAddress_Pincode(Integer.parseInt(addressmodel.get("address_pincode")));
		address.setAddress_Type(addressmodel.get("address_type"));
		address.setAddress_Id(Integer.parseInt(addressmodel.get("address_id")));
		
		try
		{
		    	 
			       if(address_dao.updateAddress(address))
	                {
			    	  
						model.addAttribute("error1",false);	
						model.addAttribute("success", true);
						model.addAttribute("error2",false);
						model.addAttribute("message","Address Successfully Updated");
	                 }
	              else
	                {
	            	
	  			   	model.addAttribute("error1",false);
	  				model.addAttribute("error2",true);	
	  				model.addAttribute("success",false);
	  				model.addAttribute("message","Address Already Exist");
	                 }
		    	 }
		
		   catch(Exception e)
		{
	
			   	model.addAttribute("error1",false);
				model.addAttribute("error2",true);	
				model.addAttribute("success",false);
				model.addAttribute("message","Address Already Exist");
			   
		}
			
		     model.addAttribute("addresspage", true );
		     model.addAttribute("addresslist", address_dao.selectAllAddress(customer));
		  
		    return "index";
 }
	

}
