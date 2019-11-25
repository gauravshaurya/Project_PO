  
package com.iris.daosimpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iris.daos.PurchaseOrderDao;
import com.iris.models.PurchaseOrder;

@Transactional
@Repository("purchaseOrderDao")
public class PurchaseOrderDaoImpl implements PurchaseOrderDao {

	@Autowired
	SessionFactory sessionFactory;

	
	public boolean addPurchaseOrder(PurchaseOrder poObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
	
			session.persist(poObj);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}