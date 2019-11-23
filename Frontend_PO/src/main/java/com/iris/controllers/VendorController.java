package com.iris.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iris.daos.ProductDao;
import com.iris.daos.VendorProductDao;
import com.iris.models.VendorProduct;

@Controller
public class VendorController {
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = "/addProductQuantity", method = RequestMethod.GET)
	public String addProductQuantity(ModelMap map) {
		map.addAttribute("vpObj", productDao.viewAllProducts());
		return "AddProductQuantity";

	}
	
	@Autowired
	VendorProductDao vendorProductDao;
	
	@RequestMapping(value = "/addToVendorProduct", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute() VendorProduct vpObj, BindingResult result) {
		vendorProductDao.addVendorProduct(vpObj);

		ModelAndView mv = new ModelAndView("AddProductQuantity");
		mv.addObject("msg", "Quantity added.");
		return mv;
	}
}
