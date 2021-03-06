package com.niit.FirstChoiceFrontEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.FirstChoiceBackEnd.DAO.IProductDAO;


@Controller
public class HomeController 
{
	@Autowired
	IProductDAO product_dao;
	
	@RequestMapping(value={"/","/home"})

	  String IndexPage(Model model)
	  {
	    model.addAttribute("indexpage",true);
	    model.addAttribute("tittle","FirstChoice--Home");
	    return "index";
	  }

	@RequestMapping("/aboutus")

	  String AboutusPage(Model model)
	  {
	    model.addAttribute("aboutuspage",true);
	    model.addAttribute("tittle","FirstChoice--Aboutus");
	    return "index";
	  }

	@RequestMapping("/contactus")

	  String ContactusPage(Model model)
	  {
	    model.addAttribute("contactuspage",true);
	    model.addAttribute("tittle","FirstChoice--contactus");
	    return "index";
	  }
	
	@RequestMapping("/allproducts")

	  String allProductPage(Model model)
	  {
	    model.addAttribute("cust_productpage",true);
	    model.addAttribute("tittle","FirstChoice--login");
	    model.addAttribute("productlist", product_dao.selectAllProduct());
	    return "index";
	  }
	
	@RequestMapping("/productdetails")
	String productDetails(@RequestParam("productid") int product_id , Model model)
	{
		 model.addAttribute("productdetails_page",true);
		model.addAttribute("product",product_dao.selectOneProduct(product_id));
	    model.addAttribute("tittle","FirstChoice--product");
	    return "index";
	
	}
	
}
