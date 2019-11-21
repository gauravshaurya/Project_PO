package com.iris.servicesimpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.UserDao;
import com.iris.models.User;
import com.iris.services.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	public boolean registerUser(User uObj) {
		uObj.setRoleId(1);
		uObj.setCreatedDate(LocalDate.now());
		uObj.setCreatedBy("System");
		uObj.setIsActive("Y");
		return userDao.registerUser(uObj);
		
	}

	public User loginUser(String email, String password) {
		User uObj=userDao.loginUser(email, password);
		return uObj;
	}	
}
