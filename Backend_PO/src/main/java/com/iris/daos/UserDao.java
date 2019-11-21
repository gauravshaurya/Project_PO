package com.iris.daos;

import com.iris.models.User;

public interface UserDao {
	public boolean registerUser(User uObj);
	public User loginUser(String email, String password);
}
