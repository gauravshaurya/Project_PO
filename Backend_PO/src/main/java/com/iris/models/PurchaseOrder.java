package com.iris.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PurchaseOrderTab")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	private int purchaseOrderId;
	
	@ManyToOne
	@JoinColumn(name="buyer_Id")
	private User buyerObj;
	
	@ManyToOne
	@JoinColumn(name="Seller_Id")
	private User sellerObj;
	
	@OneToMany(mappedBy="purchaseOrderObj",cascade=CascadeType.ALL)
	private List<PurchaseOrderItems> purchaseOrderItemsObj;

	public int getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(int purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public User getBuyerObj() {
		return buyerObj;
	}

	public void setBuyerObj(User buyerObj) {
		this.buyerObj = buyerObj;
	}

	public User getSellerObj() {
		return sellerObj;
	}

	public void setSellerObj(User sellerObj) {
		this.sellerObj = sellerObj;
	}

	public List<PurchaseOrderItems> getPurchaseOrderItemsObj() {
		return purchaseOrderItemsObj;
	}

	public void setPurchaseOrderItemsObj(List<PurchaseOrderItems> purchaseOrderItemsObj) {
		this.purchaseOrderItemsObj = purchaseOrderItemsObj;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseOrderId=" + purchaseOrderId + ", buyerObj=" + buyerObj + ", sellerObj="
				+ sellerObj + "]";
	}
	
	
	
		
}