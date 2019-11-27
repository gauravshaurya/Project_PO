package com.iris.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.ProductDao;
import com.iris.daos.SellerDao;
import com.iris.daos.UserDao;
import com.iris.models.PurchaseOrder;

@Controller
public class SellerController {
	
	@Autowired
	SellerDao sellerDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDaoObj;
	
	@RequestMapping(value="/purchaseOrders", method=RequestMethod.GET)
	public ModelAndView getPurchaseOrders() {
		
		List<PurchaseOrder> pos=sellerDao.getPurchaseOrders();
		
		ModelAndView mv=new ModelAndView("PurchaseOrders");
		mv.addObject("pList", pos);
		return mv;
	}
	
	@RequestMapping(value = "/getAllBuyers", method = RequestMethod.GET)
	public String getAllBuyers(ModelMap map) {
		
		map.addAttribute("buyerDetails", userDao.getAllBuyers()); 
		
		return "ViewAllBuyers"; 
	}
	
	@RequestMapping(value = "/viewProductsSeller", method = RequestMethod.GET)
	public String viewAllProducts(ModelMap map) {
		
		map.addAttribute("productDetails", productDaoObj.viewAllProducts());   //call to method to view all products
		
		return "ViewProductsSeller";    //jsp page showing all products detail
	}
}
