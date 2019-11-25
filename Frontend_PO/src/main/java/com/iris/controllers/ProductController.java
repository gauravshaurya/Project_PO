package com.iris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.ProductDao;
import com.iris.models.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDao productDao;

	@RequestMapping(value = "/createPurchaseOrder", method = RequestMethod.GET)
	public String homeController(ModelMap map) {

		map.addAttribute("productDetails", productDao.viewAllProducts());
		return "CreatePurchaseOrder";

	}

	/*
	 * @RequestMapping(value = "/viewAllProducts", method = RequestMethod.GET)
	 * public ModelAndView getAllProducts() { ModelAndView mv = new
	 * ModelAndView("ViewProducts"); mv.addObject("productDetails",
	 * productDao.viewAllProducts()); return mv; }
	 */
	@ResponseBody
	@RequestMapping(value="/getProductById",method=RequestMethod.GET)
	public Product getProductById(@RequestParam int productId) {
		
		Product pObj=productDao.getProductById(productId);
		return pObj;
	}

}