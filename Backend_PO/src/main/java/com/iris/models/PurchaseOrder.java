package com.iris.models;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int poNumber;
	
	private User buyerId;
	
	private User sellerId;
	
	private User vendorId;
	
	private Product productId;
	
	private String productName;
	
	private int productQuantity;
	
	private LocalDate createdDate;

	public int getPoNumber() {
		return poNumber;
	}

	public void setPoNumber(int poNumber) {
		this.poNumber = poNumber;
	}

	public User getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(User buyerId) {
		this.buyerId = buyerId;
	}

	public User getSellerId() {
		return sellerId;
	}

	public void setSellerId(User sellerId) {
		this.sellerId = sellerId;
	}

	public User getVendorId() {
		return vendorId;
	}

	public void setVendorId(User vendorId) {
		this.vendorId = vendorId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "PurchaseOrder [poNumber=" + poNumber + ", buyerId=" + buyerId + ", sellerId=" + sellerId + ", vendorId="
				+ vendorId + ", productId=" + productId + ", productName=" + productName + ", productQuantity="
				+ productQuantity + ", createdDate=" + createdDate + "]";
	}
}
