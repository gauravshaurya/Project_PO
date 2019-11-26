package com.iris.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.ProductDao;
import com.iris.daos.VendorProductDao;
import com.iris.models.User;
import com.iris.models.VendorProduct;

@Controller
public class VendorController {
	
	@Autowired
	VendorProductDao vendorProductDaoObj;
	
	@Autowired
	HttpSession session;
	
	
	@Autowired
	ProductDao productDaoObj;
	
	public boolean checkSession(ModelMap map) {
		if(session.getAttribute("uObj")==null){
			map.addAttribute("msg","Session does not exist");
			return true;	
		}	
		return false;	
	}
	
	//view those products added by the vendor by adding quantity
	@RequestMapping(value = "/viewAllAvailableProducts", method = RequestMethod.GET)
	public String viewAllAvailableProducts(ModelMap map) {
		
		User userObj=(User)session.getAttribute("uObj");     
		int vendorId=userObj.getUserId();                      //fetch id through session 
		
		map.addAttribute("vendorProductDetails", vendorProductDaoObj.viewAllVendorProducts(vendorId));    //view products added by vendor getallProducts method in vendouproductdao
				
		return "ViewVendorProduct";      //return view product

	}
	
	//all products available in product table
	@RequestMapping(value = "/viewAllProducts", method = RequestMethod.GET)
	public String viewAllProducts(ModelMap map) {
		
		map.addAttribute("productDetails", productDaoObj.viewAllProducts());   //call to method to view all products
		
		return "ViewAllProducts";    //jsp page showing all products detail
	}
	
	
	
	//get add or update quantity form
	@RequestMapping(value="/addProductQuantity",method=RequestMethod.GET)
	public String getUpdateQuantityForm(ModelMap map) {
		map.addAttribute("productDetails", productDaoObj.viewAllProducts());   //fetch details in drop down menu
 		return "AddProductQuantity";    //open form
	}

	
	
	//save or update product
	@RequestMapping(value="/addProductQuantity",method=RequestMethod.POST)
	public ModelAndView addInVendorProductTable(@RequestParam int pId  , @RequestParam int quantity){
		User userObj=(User)session.getAttribute("uObj");		 //get id from session
		VendorProduct r=vendorProductDaoObj.checkProductForVendor(userObj.getUserId(), pId);  //check for product already added if already present then update the quantity else add the quantity
		if(r!=null) {
			r.setQuantity(r.getQuantity()+quantity);      //already present then add quantity to existing value
		}
		else {
			r = new VendorProduct();				//else create new object and set values 
			r.setVendorId(userObj.getUserId());
			r.setProductId(pId);
			r.setQuantity(quantity);
		}
		
		vendorProductDaoObj.add(r);                    //call add method from dao
		
		ModelAndView mv=new ModelAndView("AddProductQuantity");
		mv.addObject("msg","Product Quantity Added Succesfully");
		return mv;
		

		/*
		 * if(checkSession(map)) { ModelAndView mv1=new ModelAndView("IndexPage");
		 * return mv1; }
		 */

	}
	

}
