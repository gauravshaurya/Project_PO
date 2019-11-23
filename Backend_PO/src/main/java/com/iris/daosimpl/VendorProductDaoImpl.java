package com.iris.daosimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.VendorProductDao;
import com.iris.models.VendorProduct;

@Repository("vendorProductDao")
@Transactional
public class VendorProductDaoImpl implements VendorProductDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addVendorProduct(VendorProduct vpObj) {
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(vpObj);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<VendorProduct> viewVendorProduct() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from com.iris.models.Product");
			return query.list();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

}
