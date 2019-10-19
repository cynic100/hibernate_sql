package com.hibernate01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class CustomerTest {

	@Test
	public void Test() {
		
		Configuration configuration=new Configuration().configure();
		
		SessionFactory buildSessionFactory = configuration.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		
		Transaction beginTransaction = openSession.beginTransaction();
		
		try {
			Customer customer = new Customer();
			customer.setCust_id(1);
			customer.setCust_name("测试2");
			openSession.save(customer);
			beginTransaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		openSession.close();
		buildSessionFactory.close();
		
		
	}
}
