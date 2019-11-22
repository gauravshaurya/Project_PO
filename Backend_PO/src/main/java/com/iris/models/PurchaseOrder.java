package com.iris.models;

import java.time.LocalDate;

public class PurchaseOrder {
	
	private User userName;
	
	private User phone;
	
	private User address;
	
	private User email;
	
	private String sellerName;
	
	private String productName;
	
	private int productQuantity;
	
	private LocalDate createdDate;
	
	private int poNumber;

	public User getUserName() {
		return userName;
	}

	public void setUserName(User userName) {
		this.userName = userName;
	}

	public User getPhone() {
		return phone;
	}

	public void setPhone(User phone) {
		this.phone = phone;
	}

	public User getAddress() {
		return address;
	}

	public void setAddress(User address) {
		this.address = address;
	}

	public User getEmail() {
		return email;
	}

	public void setEmail(User email) {
		this.email = email;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public int getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [userName=" + userName + ", phone=" + phone + ", address=" + address + ", email=" + email
				+ ", sellerName=" + sellerName + ", productName=" + productName + ", productQuantity=" + productQuantity
				+ ", createdDate=" + createdDate + ", poNumber=" + poNumber + "]";
	}
}
