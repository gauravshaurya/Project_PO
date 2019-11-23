package com.iris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_vp")
public class VendorProduct {
	
	@Id
	@GeneratedValue
	@Column(name="vp_id")
	private int vpId;
	@Column(name="product_id")
	private Product productId;
	@Column(name="product_name")
	private Product productName;
	@Column(name="product_price")
	private Product price;
	@Column(name="quantity")
	private int quantity;
	@Column(name="vendor_id")
	private User vendorId;

	public int getVpId() {
		return vpId;
	}

	public void setVpId(int vpId) {
		this.vpId = vpId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Product getProductName() {
		return productName;
	}

	public void setProductName(Product productName) {
		this.productName = productName;
	}

	public Product getPrice() {
		return price;
	}

	public void setPrice(Product price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public User getVendorId() {
		return vendorId;
	}

	public void setVendorId(User vendorId) {
		this.vendorId = vendorId;
	}

	@Override
	public String toString() {
		return "VendorProduct [vpId=" + vpId + ", productId=" + productId + ", productName=" + productName + ", price="
				+ price + ", quantity=" + quantity + ", vendorId=" + vendorId + "]";
	}
}
