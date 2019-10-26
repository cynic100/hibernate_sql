package com.hibernate02;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.hibernate01.Customer;
import com.hibernate01.utils.HibernateUtils;

public class HibernateDemo01 {

	@Test
	public void Demo1() {
		Session currentSession = HibernateUtils.getCurrentSession();
		Transaction beginTransaction = currentSession.beginTransaction();

		try {
			//简单查询
			String sql = "FROM Customer";
			//条件查询
			//	String sql="FROM Customer where cust_id=1 ";
			Query createQuery = currentSession.createQuery(sql);
			//分页查询
			createQuery.setFirstResult(4);
			createQuery.setMaxResults(3);
			List<Customer> list = createQuery.list();
			for (Customer customer : list) {
				System.out.println(customer);
			}
			beginTransaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	public void Demo2() {
		
		Session currentSession = HibernateUtils.getCurrentSession();
		Transaction beginTransaction = currentSession.beginTransaction();

		Criteria createCriteria = currentSession.createCriteria(Customer.class);
//		createCriteria.add(Restrictions.like("cust_id", 1));
//		createCriteria.add(Restrictions.like("cust_name", "%2%"));
		//分页查询
		createCriteria.setFirstResult(4);
		createCriteria.setMaxResults(3);
		List<Customer> list = createCriteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		beginTransaction.commit();
	}

}
