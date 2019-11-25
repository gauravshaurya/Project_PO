package com.iris.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iris.models.User;
import com.iris.services.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexPage(ModelMap map) {
		map.addAttribute("myIndex", "Welcome to Purchase Order Tool");

		return "IndexPage";
	}

	@RequestMapping(value = "/getRegistrationForm", method = RequestMethod.GET)
	public String displayRegistrationForm(ModelMap map) {
		map.addAttribute("uObj", new User());

		return "RegistrationForm";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute() User uObj, BindingResult result) {
		userService.registerUser(uObj);

		ModelAndView mv = new ModelAndView("IndexPage");
		mv.addObject("msg", "Buyer has been registered succesfully. Now u can Login");
		return mv;
	}

	@RequestMapping(value = "/getLoginPage", method = RequestMethod.GET)
	public String displayLoginPage(ModelMap map) {
		map.addAttribute("userObj", new User());
		return "IndexPage";
	}

	@Autowired
	HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@RequestParam String email, @RequestParam String password) {
		
		System.out.println(email+" "+password);
		User uObj = userService.loginUser(email, password);
		System.out.println("User Obj : " + uObj);
		if (uObj != null) {

			session.setAttribute("uObj", uObj);

			int id = uObj.getRoleId();

			if (id == 1) {
				return "BuyerPage";
			} 
			else if (id == 2) {
				return "SellerPage";
			} 
			else if(id == 3) {
				return "VendorPage";
			}
			else {
				return null;
			}
		}

		return "LoginPage";
	}
}
