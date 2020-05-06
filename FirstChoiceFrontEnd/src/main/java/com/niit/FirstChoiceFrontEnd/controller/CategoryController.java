package com.niit.FirstChoiceFrontEnd.controller;


import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			model.addAttribute("edit",false);
			model.addAttribute("error1",false);	
 			model.addAttribute("success",false);
 			model.addAttribute("error2",false);
 			model.addAttribute("message","");
		    model.addAttribute("categorypage",true);
		    model.addAttribute("categoryobject",new ProductCategory());
		    model.addAttribute("catlist",category_dao.selectAllCategory());
		    model.addAttribute("tittle","FirstChoice--category");
		    return "index";
		  }
		
		@RequestMapping("/addcategory")	
	   String addCategoryPage(@Valid @ModelAttribute("categoryobject") ProductCategory category,BindingResult br,Model model)
		  {
		try
		{
		    	 if(br.hasErrors())
		    	 {
		    		
		 			model.addAttribute("categoryobject", category);
		 			model.addAttribute("error1",true);	
		 			model.addAttribute("success",false);
		 			model.addAttribute("error2",false);
		 			model.addAttribute("message","Incorrect Data");
			 			
		    	 }
		    	 else
		    	 {
			       if(category_dao.addCategory(category))
	                {
			    	  
						model.addAttribute("categoryobject",new ProductCategory());
						model.addAttribute("error1",false);	
						model.addAttribute("success", true);
						model.addAttribute("error2",false);
						model.addAttribute("message","Sucessfully Added");
	                 }
	              else
	                {
	            	
	  				 model.addAttribute("categoryobject", category);
	  			   	model.addAttribute("error1",false);
	  				model.addAttribute("error2",true);	
	  				model.addAttribute("success",false);
	  				model.addAttribute("message","Data Already Exist");
	                 }
		    	 }
		      }
		   catch(Exception e)
		{
	
				 model.addAttribute("categoryobject", category);
			   	model.addAttribute("error1",false);
				model.addAttribute("error2",true);	
				model.addAttribute("success",false);
				model.addAttribute("message","Data Already Exist");
			   
		}
	    	model.addAttribute("edit",false);
		    model.addAttribute("categorypage",true);
		    model.addAttribute("catlist",category_dao.selectAllCategory());
		    model.addAttribute("tittle","FirstChoice--category");
		    return "index";
		  }
      	
		@RequestMapping("/deletecategory")
		String deleteCategory(@RequestParam("catname") String category_name , Model model)
		{
			try
			{
					ProductCategory category = category_dao.selectOneCategory(category_name);
					
					if(category_dao.deleteCategory(category))
					{
						
						model.addAttribute("error1",false);	
						model.addAttribute("success", true);
						model.addAttribute("error2",false);
						model.addAttribute("message","Sucessfully Deleted");
					}
					else
					{
						
			 			model.addAttribute("error1",true);	
			 			model.addAttribute("success",false);
			 			model.addAttribute("error2",false);
			 			model.addAttribute("message","Deletion Unsucessful");
			 		
					}
			}
			catch(Exception e)
			{
				
	 			model.addAttribute("error1",true);	
	 			model.addAttribute("success",false);
	 			model.addAttribute("error2",false);
	 			model.addAttribute("message","Deletion Unsucessful");
	 
			}
			
			model.addAttribute("edit",false);
			model.addAttribute("categorypage",true);
		    model.addAttribute("categoryobject",new ProductCategory());
		    model.addAttribute("catlist",category_dao.selectAllCategory());
		    model.addAttribute("tittle","FirstChoice--category");
		  return "index";
		  
		}

		@RequestMapping("/getcategorytoedit")
		String getCategoryToEdit(@RequestParam("catname") String category_name , Model model)
		{
			model.addAttribute("edit",true);
			model.addAttribute("error1",false);	
			model.addAttribute("success", false);
			model.addAttribute("error2",false);
			model.addAttribute("categorypage",true);
		    model.addAttribute("categoryobject",category_dao.selectOneCategory(category_name));
		    model.addAttribute("catlist",category_dao.selectAllCategory());
		    model.addAttribute("tittle","FirstChoice--category");
		    return "index";
		}
		

		@RequestMapping("/updatecategory")	
	   String updateCategoryPage(@Valid @ModelAttribute("categoryobject") ProductCategory category,BindingResult br,Model model)
		  {
		try
		{
		    	 if(br.hasErrors())
		    	 {
		    		
		 			model.addAttribute("categoryobject", category);
		 			 model.addAttribute("edit",true);
		 			model.addAttribute("error1",true);	
		 			model.addAttribute("success",false);
		 			model.addAttribute("error2",false);
		 			model.addAttribute("message","Incorrect Data");
		 			
		    	 }
		    	 else
		    	 {
			       if(category_dao.updateCategory(category))
	                {
			    	  
						model.addAttribute("categoryobject",new ProductCategory());
						model.addAttribute("edit",false);
						model.addAttribute("error1",false);	
						model.addAttribute("success", true);
						model.addAttribute("error2",false);
						model.addAttribute("message","Sucessfully Updated");
	                 }
	              else
	                {
	            	
	  				 model.addAttribute("categoryobject", category);
	  				 model.addAttribute("edit",true);
	  			   	model.addAttribute("error1",false);
	  				model.addAttribute("error2",true);	
	  				model.addAttribute("success",false);
	  				model.addAttribute("message","Data Already Exist");
	                 }
		    	 }
		      }
		   catch(Exception e)
		{
	
				 model.addAttribute("categoryobject", category);
				 model.addAttribute("edit",true);
			   	model.addAttribute("error1",false);
				model.addAttribute("error2",true);	
				model.addAttribute("success",false);
				model.addAttribute("message","Data Already Exist");
			   
		}
	    	
		    model.addAttribute("categorypage",true);
		    model.addAttribute("catlist",category_dao.selectAllCategory());
		    model.addAttribute("tittle","FirstChoice--category");
		    return "index";
		  }
}
