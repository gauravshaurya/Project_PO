package com.iris.daos;

import java.util.List;

import com.iris.models.VendorProduct;

public interface VendorProductDao {
	public boolean addVendorProduct(VendorProduct vpObj);
	public List<VendorProduct> viewVendorProduct();
}
