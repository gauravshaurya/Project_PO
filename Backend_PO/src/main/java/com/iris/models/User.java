package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@NotEmpty
	private String userName;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String phone;
	
	@NotEmpty
	private String email;

	@NotEmpty
	@Size(min=4,max=12,message="Password should be between 3 to 12 characters")
	@Column(name="userPass")
	private String password;
	
	@Column(name="roleId")
	private int roleId=1;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + ", roleId=" + roleId + "]";
	}
	
}
