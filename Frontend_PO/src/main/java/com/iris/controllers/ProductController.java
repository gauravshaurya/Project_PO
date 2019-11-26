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

	@ResponseBody
	@RequestMapping(value="/getProductById",method=RequestMethod.GET)
	public Product getProductById(@RequestParam int productId) {
		System.out.println("I m here in controller");
		Product pObj=productDao.getProductById(productId);
		System.out.println("Product Obj : "+pObj);
		return pObj;
	}

}