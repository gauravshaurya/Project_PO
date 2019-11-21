package com.iris.services;

import com.iris.models.User;

public interface UserService {
	public boolean registerUser(User uObj);
	public User loginUser(String email, String password);
}
