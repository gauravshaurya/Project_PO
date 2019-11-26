package com.iris.daos;

import java.util.List;

import com.iris.models.PurchaseOrder;

public interface PurchaseOrderDao {
	
	public boolean addPurchaseOrder(PurchaseOrder pobj);
	public List<PurchaseOrder> getPurchaseOrders();

}