package com.niit.FirstChoiceFrontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping(value={"/","/home"})

	  String IndexPage(Model model)
	  {
	    model.addAttribute("indexpage",true);
	    model.addAttribute("tittle","OurWeb--Home");
	    return "index";
	  }

	@RequestMapping("/aboutus")

	  String AboutusPage(Model model)
	  {
	    model.addAttribute("aboutuspage",true);
	    model.addAttribute("tittle","OurWeb--Aboutus");
	    return "index";
	  }

	@RequestMapping("/contactus")

	  String ContactusPage(Model model)
	  {
	    model.addAttribute("contactuspage",true);
	    model.addAttribute("tittle","OurWeb--contactus");
	    return "index";
	  }
	@RequestMapping("/login")

	  String LoginPage(Model model)
	  {
	    model.addAttribute("loginpage",true);
	    model.addAttribute("tittle","OurWeb--login");
	    return "index";
	  }

	@RequestMapping("/register")

	  String RegisterPage(Model model)
	  {
	    model.addAttribute("registerpage",true);
	    model.addAttribute("tittle","OurWeb--register");
	    return "index";
	  }
}
