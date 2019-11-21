package com.iris.Backend_PO;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iris.config.DBConfig;
import com.iris.models.Address;
import com.iris.models.User;
import com.iris.services.UserService;

import junit.framework.TestCase;

public class AppTest {
	
	private static UserService userService;
	
	@BeforeClass
	public static void init() {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		userService = context.getBean("userService",UserService.class);
		System.out.println("I'm initialised.");
	}
	
	@Test
	public void registerUser() {
		
		Address aObj = new Address();
		
		aObj.setHouseNo(95);
		aObj.setAddress1("Block C");
		aObj.setAddress2("Sector-P3");
		aObj.setCity("Greater Noida");
		aObj.setState("UP");
		aObj.setPincode(201308);
		
		User uObj = new User();
		
		uObj.setUserName("Gourav Kumar");
		uObj.setEmail("gourav@gmail.com");
		uObj.setAddress(aObj);
		uObj.setPassword("g1234");
		uObj.setRoleId(1);
		uObj.setPhone(9650187167l);
		uObj.setCreatedBy("System");
		uObj.setCreatedDate(LocalDate.now());
		uObj.setIsActive("Y");
		
		boolean b = userService.registerUser(uObj);
		assertTrue("Problem in Registering User.",b);	
	}    
}
