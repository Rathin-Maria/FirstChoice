package com.niit.FirstChoiceFrontEnd.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.niit.FirstChoiceBackEnd.DAO.ICategoryDAO;
import com.niit.FirstChoiceBackEnd.Model.ProductCategory;

@Controller
public class CategoryController 
{

	@Autowired
	ICategoryDAO category_dao;
	
	
		@RequestMapping("/category")

		  String CategoryPage(Model model)
		  {
		    model.addAttribute("categorypage",true);
		    model.addAttribute("categoryobject",new ProductCategory());
		    model.addAttribute("tittle","FirstChoice--category");
		    return "index";
		  }
		
		@RequestMapping("/addcategory")	
	   String addCategoryPage(@ModelAttribute("categoryobject") ProductCategory category,Model model)
		  {
		try
		 {
			if(category_dao.addCategory(category))
	        {
	            model.addAttribute("info",true);
	            model.addAttribute("message","Category Added"); 
	            System.out.println("Done");
	        }
	        else
	        {
	          model.addAttribute("info",true);
	          model.addAttribute("message","Invalid Category  Name or Category exists");
	          System.out.println("Faliure");
	        }
		 }
		
		catch(Exception e1)
		{
			 model.addAttribute("info",true);
	          model.addAttribute("message","Invalid Category  Name or Category exists");
	          System.out.println("Faliure");
			
		}
			
		    model.addAttribute("categorypage",true);
		    model.addAttribute("categoryobject",new ProductCategory());
		    model.addAttribute("tittle","FirstChoice--category");
		    return "index";
		  }
		

}
