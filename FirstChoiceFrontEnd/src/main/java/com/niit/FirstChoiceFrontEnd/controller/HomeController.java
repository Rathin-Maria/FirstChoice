package com.niit.FirstChoiceFrontEnd.controller;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping("/")

	  String IndexPage()
	  {
	    
	    return "index";
	  }
}
