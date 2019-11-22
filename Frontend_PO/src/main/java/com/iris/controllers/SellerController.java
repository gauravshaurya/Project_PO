package com.iris.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.SellerDao;
import com.iris.models.PurchaseOrder;

@Controller
public class SellerController {
	
	@Autowired
	SellerDao sellerDao;
	
	@RequestMapping(value="/purchaseOrders", method=RequestMethod.GET)
	public ModelAndView getPurchaseOrders() {
		
		List<PurchaseOrder> pos=sellerDao.getPurchaseOrders();
		
		ModelAndView mv=new ModelAndView("PurchaseOrders");
		mv.addObject("pList", pos);
		return mv;
	}

}
