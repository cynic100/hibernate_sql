package com.hibernate03.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate03.Customer;
import com.hibernate03.LinkMan;
import com.hibernate03.utils.HibernateUtils;

public class Demo01 {

	@Test
	public void Save1() {
		Session session = HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();

		Customer customer1 = new Customer();
		customer1.setCust_name("客户111");

		Customer customer2 = new Customer();
		customer2.setCust_id(0);
		customer2.setCust_name("客户222");

		LinkMan linkMan1 = new LinkMan();
		linkMan1.setLkm_id(0);
		linkMan1.setLkm_name("联系人111");
		LinkMan linkMan2 = new LinkMan();
		linkMan2.setLkm_id(0);
		linkMan2.setLkm_name("联系人222");
		LinkMan linkMan3 = new LinkMan();
		linkMan3.setLkm_id(0);
		linkMan3.setLkm_name("联系人333");

		session.save(customer1);
		session.save(customer2);

		linkMan1.setCustomer(customer1);
		linkMan2.setCustomer(customer1);
		linkMan3.setCustomer(customer2);

		session.save(linkMan1);
		session.save(linkMan2);
		session.save(linkMan3);

		beginTransaction.commit();

	}

}
