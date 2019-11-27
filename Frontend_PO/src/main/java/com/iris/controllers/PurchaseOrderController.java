package com.iris.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.daos.ProductDao;
import com.iris.daos.PurchaseOrderDao;
import com.iris.daos.UserDao;
import com.iris.models.PurchaseOrder;
import com.iris.models.PurchaseOrderItems;
import com.iris.models.User;
import com.sun.media.jfxmedia.logging.Logger;

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
	PurchaseOrderDao purchaseOrderdao;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = "/getPurchaseOrderForm", method = RequestMethod.GET)
	public String getPurchaseOrderForm(ModelMap map) {

		map.addAttribute("productDetails", productDao.viewAllProducts());
		return "PurchaseOrderForm";

	}
	
	@ResponseBody
	@RequestMapping(value="/createPurchaseOrder",method=RequestMethod.POST)
	public String raisePurchaseOrder(@RequestBody List<PurchaseOrderItems> purchaseOrderItemsList,ModelMap map) {
		
		System.out.println("Inside Create Purchase Order ");
		
		User uObj=(User)session.getAttribute("uObj");
		
		PurchaseOrder po=new PurchaseOrder();
		po.setBuyerObj(uObj);
		po.setSellerObj(userDao.getSeller());
		po.setStatus("Forwarded to seller");


		
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
	
	@RequestMapping(value = "/purchaseOrderBuyer", method = RequestMethod.GET)
	public String purchaseOrderBuyer(ModelMap map) {
		System.out.println(purchaseOrderDao.getPurchaseOrders());
		map.addAttribute("purchaseOrders", purchaseOrderDao.getPurchaseOrders());   //call to method to view purchase orders
		
		return "PurchaseOrderBuyer";    //jsp page showing all purchase order details
	}
	
	@RequestMapping(value = "/purchaseOrderSeller", method = RequestMethod.GET)
	public String purchaseOrderSeller(ModelMap map) {
		System.out.println(purchaseOrderDao.getPurchaseOrders());
		map.addAttribute("purchaseOrders", purchaseOrderDao.getPurchaseOrders());   //call to method to view purchase orders
		
		return "PurchaseOrderSeller";    //jsp page showing all purchase order details
	}
	
	@RequestMapping(value = "/purchaseOrderVendor", method = RequestMethod.GET)
	public String purchaseOrderVendor(ModelMap map) {
		System.out.println(purchaseOrderDao.getPurchaseOrders());
		map.addAttribute("purchaseOrders", purchaseOrderDao.getPurchaseOrders());   //call to method to view purchase orders
		
		return "PurchaseOrderVendor";    //jsp page showing all purchase order details
	}

}