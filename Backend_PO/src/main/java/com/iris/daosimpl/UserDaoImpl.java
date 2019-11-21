package com.iris.daosimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.UserDao;
import com.iris.models.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
		@Autowired
		SessionFactory sessionFactory;

		public boolean registerUser(User uObj) {
			try {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(uObj);
				return true;
			} catch (Exception e) {
					e.printStackTrace();
			
			}
			return false;
		}

		public User loginUser(String email, String password) {
				try {
					Session session = sessionFactory.getCurrentSession();
					User uObj=session.get(User.class, email);
					
				if(uObj!=null) {
					if(uObj.getPassword().equals(password));
							return uObj;
				}
				} catch (Exception e) {
						
				}
			return null;
		}
}
