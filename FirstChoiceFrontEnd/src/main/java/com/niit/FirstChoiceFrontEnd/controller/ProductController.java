package com.niit.FirstChoiceFrontEnd.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;   

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.FirstChoiceBackEnd.DAO.ICategoryDAO;
import com.niit.FirstChoiceBackEnd.DAO.IProductDAO;
import com.niit.FirstChoiceBackEnd.Model.Product;
 

@Controller
public class ProductController 
{

		@Autowired
		IProductDAO product_dao;
		@Autowired
		ICategoryDAO category_dao;
		
			@RequestMapping("/products")

			String  ProductPage(Model model)
			  {
				model.addAttribute("edit",false);
				model.addAttribute("error1",false);	
	 			model.addAttribute("success",false);
	 			model.addAttribute("error2",false);
	 			model.addAttribute("message","");
			    model.addAttribute("productpage",true);
			    model.addAttribute("productobject",new Product());
			    model.addAttribute("productlist", product_dao.selectAllProduct());
			    model.addAttribute("catlist",category_dao.selectAllCategory());
			    model.addAttribute("tittle","FirstChoice--product");
			    return "index";
			  }
			

			@RequestMapping("/addproducts")	
				   String addProductPage(@Valid @ModelAttribute("productobject") Product product, BindingResult br,Model model)
					  {
					try
					{
					    	 if(br.hasErrors())
					    	 {
					    		
					 			model.addAttribute("productobject", product);
					 			model.addAttribute("error1",true);	
					 			model.addAttribute("success",false);
					 			model.addAttribute("error2",false);
					 			model.addAttribute("message","Incorrect Data");
					 			
					    	 }
					    	 else
					    	 {
						       if(product_dao.addProduct(product))
				                {
						    	  
						    	   addImage(product.getProduct_Id(),product.getProduct_Image());
						    	    model.addAttribute("productobject",new Product());
									model.addAttribute("error1",false);	
									model.addAttribute("success", true);
									model.addAttribute("error2",false);
									model.addAttribute("message","Sucessfully Added");
				                 }
				              else
				                {
				            	
				            	model.addAttribute("productobject", product);
				  			   	model.addAttribute("error1",false);
				  				model.addAttribute("error2",true);	
				  				model.addAttribute("success",false);
				  				model.addAttribute("message","Data Already Exist");
				                 }
					    	 }
					      }
					   catch(Exception e)
					{
				
						   model.addAttribute("productobject", product);
						   	model.addAttribute("error1",false);
							model.addAttribute("error2",true);	
							model.addAttribute("success",false);
							model.addAttribute("message","Data Already Exist");
						   
					}
						
					     model.addAttribute("edit",false);
					    model.addAttribute("productpage",true);	 
					    model.addAttribute("productlist", product_dao.selectAllProduct());
					    model.addAttribute("catlist",category_dao.selectAllCategory());
					    model.addAttribute("tittle","FirstChoice--product");
					    return "index";
			  }
			
			@RequestMapping("/deleteproducts")
			String deleteProduct(@RequestParam("productid") int product_id , Model model)
			{
				try
				{
						Product product = product_dao.selectOneProduct(product_id);
						
						if(product_dao.deleteProduct(product))
						{
							deleteImage(product_id);
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
				 model.addAttribute("productpage",true);
				model.addAttribute("productobject",new Product());
			    model.addAttribute("productlist", product_dao.selectAllProduct());
			    model.addAttribute("catlist",category_dao.selectAllCategory());
			    model.addAttribute("tittle","FirstChoice--product");
			  return "index";
			  
			}
		      	
			@RequestMapping("/getproductstoedit")
			String getProductToEdit(@RequestParam("productid") int product_id , Model model)
			{
				model.addAttribute("edit",true);
				model.addAttribute("error1",false);	
				model.addAttribute("success", false);
				model.addAttribute("error2",false);
				 model.addAttribute("productpage",true);
				model.addAttribute("productobject",product_dao.selectOneProduct(product_id));
			    model.addAttribute("productlist", product_dao.selectAllProduct());
			    model.addAttribute("catlist",category_dao.selectAllCategory());
			    model.addAttribute("tittle","FirstChoice--product");
			    return "index";
			
			}
		
			@RequestMapping("/updateproducts")	
			   String updateProductPage(@Valid @ModelAttribute("productobject") Product product, BindingResult br,Model model)
				  {
				try
				{
				    	 if(br.hasErrors())
				    	 {
				    		 model.addAttribute("edit",true);
				 			model.addAttribute("productobject", product);
				 			model.addAttribute("error1",true);	
				 			model.addAttribute("success",false);
				 			model.addAttribute("error2",false);
				 			model.addAttribute("message","Incorrect Data");
				 			
				    	 }
				    	 else
				    	 {
					       if(product_dao.updateProduct(product))
			                {
					    	   addImage(product.getProduct_Id(),product.getProduct_Image());
					    	    model.addAttribute("edit",false);
					    	    model.addAttribute("productobject",new Product());
								model.addAttribute("error1",false);	
								model.addAttribute("success", true);
								model.addAttribute("error2",false);
								model.addAttribute("message","Sucessfully Updated");
			                 }
			              else
			                {
			            	model.addAttribute("edit",true);
			            	model.addAttribute("productobject", product);
			  			   	model.addAttribute("error1",false);
			  				model.addAttribute("error2",true);	
			  				model.addAttribute("success",false);
			  				model.addAttribute("message","Data Already Exist");
			                 }
				    	 }
				      }
				   catch(Exception e)
				{
					   model.addAttribute("edit",true);
					   model.addAttribute("productobject", product);
					   	model.addAttribute("error1",false);
						model.addAttribute("error2",true);	
						model.addAttribute("success",false);
						model.addAttribute("message","Data Already Exist");
				}
					
				     
				    model.addAttribute("productpage",true);	    
				    model.addAttribute("productlist", product_dao.selectAllProduct());
				    model.addAttribute("catlist",category_dao.selectAllCategory());
				    model.addAttribute("tittle","FirstChoice--product");
				    return "index";
		  }
		
      
			private void addImage(int product_Id, MultipartFile product_Image) 
			{
			   String path="D:\\niit-combatore\\FirstChoiceFrontEnd\\src\\main\\webapp\\resources\\productimages\\";
			   
			   try
			   {
			        path = path+String.valueOf(product_Id)+".jpeg";
			        File file= new File(path);
			        if(product_Image.getSize()!=0)
			        {
			        if(file.exists())
			        {
				        file.delete();
			         }
			        BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(file));
			     	bs.write(product_Image.getBytes());
				    bs.close();
				    Thread.sleep(5000);
			        }
			   }
			   
			   catch(Exception e)
			   {
				   System.out.println(e);
			   }

			}

			private void deleteImage(int product_Id) 
			{
			   String path="D:\\niit-combatore\\FirstChoiceFrontEnd\\src\\main\\webapp\\resources\\productimages\\";
			   
			   try
			   {
			        path = path+String.valueOf(product_Id)+".jpeg";
			        File file= new File(path);
				        file.delete();
			   }
			   
			   catch(Exception e)
			   {
				   System.out.println(e);
			   }

			}

			
	}

