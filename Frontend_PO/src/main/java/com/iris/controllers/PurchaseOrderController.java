package com.iris.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iris.daos.ProductDao;
import com.iris.daos.PurchaseOrderDao;
import com.iris.daos.UserDao;
import com.iris.models.PurchaseOrder;
import com.iris.models.PurchaseOrderItems;
import com.iris.models.User;

@Controller
public class PurchaseOrderController {
	
	@Autowired
	PurchaseOrderDao purchaseOrderDao;
	/*
	@RequestMapping(value="/purchaseOrder",method=RequestMethod.POST)
	public ModelAndView raisePurchaseOrder(@ModelAttribute("purchaseOrder") PurchaseOrder purchaseOrder,ModelMap map  ) {
		System.out.println("i m here");
		ModelAndView mv=new ModelAndView("SellerSuccess") ;
		System.out.println("i am going to finish");
		mv.addObject("msg","po is raised");
		return null;
		
		
	}*/
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value="/createPurchaseOrder",method=RequestMethod.POST)
	public String raisePurchaseOrder(@RequestBody List<PurchaseOrderItems> purchaseOrderItemsList,ModelMap map) {
		User uObj=(User)session.getAttribute("userObj");
		
		PurchaseOrder po=new PurchaseOrder();
		po.setBuyerObj(uObj);
		po.setSellerObj(userDao.getSeller());


		
		for(PurchaseOrderItems obj:purchaseOrderItemsList) {
			obj.setProductObj(productDao.getProductById(obj.getProductId()));
			obj.setPurchaseOrderObj(po);
		}
		
		po.setPurchaseOrderItemsObj(purchaseOrderItemsList);
		
				
		System.out.println("Purchase Order : "+po);
		
		
		purchaseOrderDao.addPurchaseOrder(po);
		
		map.addAttribute("msg","Purchase Order has been raised succesfully...");
		return "success";
		
		
	}

}