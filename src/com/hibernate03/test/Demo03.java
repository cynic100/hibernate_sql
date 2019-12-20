package com.hibernate03.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hibernate03.Customer;
import com.hibernate03.utils.HibernateUtils;

public class Demo03 {
	
	@Test
	public void demo01() {
		try {
			Session session = HibernateUtils.openSession();
			Transaction beginTransaction = session.beginTransaction();
			Query query = session.createSQLQuery("SELECT * FROM dbo.cst_customer");			
			List<Object[]> list = query.list();
			for (Object[] objects : list) {
				System.out.println(Arrays.toString(objects));
			}
			
			beginTransaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void demo02() {
		try {
			Session session = HibernateUtils.openSession();
			Transaction beginTransaction = session.beginTransaction();
			SQLQuery sqlQuery = session.createSQLQuery("SELECT * FROM dbo.cst_customer");	
			sqlQuery.addEntity(Customer.class);
			List<Customer> list = sqlQuery.list();
			for (Customer customer : list) {
				System.out.println(customer);
			}
			
			beginTransaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
