package com.hibernate03.test;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
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
	/**
	 * @Description: 级联保存或者更新(这里用一句话描述这个方法的作用) @author xu_yuxin @param tags 参数 @return void 返回类型 @throws
	 */
	public void Save2() {
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

		/*session.save(customer1);
		session.save(customer2);*/

		linkMan1.setCustomer(customer1);
		linkMan2.setCustomer(customer1);
		linkMan3.setCustomer(customer2);

		session.save(linkMan1);
		session.save(linkMan2);
		session.save(linkMan3);

		beginTransaction.commit();

	}

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

	@Test
	public void Insert() {
		Session session = HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCust_name("客户李");
		for (int i = 1; i < 100; i++) {
			LinkMan linkMan = new LinkMan();
			linkMan.setLkm_name("联系人" + i);
			linkMan.setCustomer(customer);

			customer.getLinkMans().add(linkMan);

			session.save(linkMan);

		}
		session.save(customer);

		beginTransaction.commit();
	}

	@Test
	public void demo01() {
		Session session = HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();

		List<LinkMan> list = session.createQuery("from LinkMan").list();
		for (Object object : list) {
			System.out.println(object);
		}

		beginTransaction.commit();
	}
	
	
	@Test
	public void demo02() {
		Session session = HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		List<LinkMan> list = session.createQuery("select c from LinkMan c").list();
		for (Object object : list) {
			System.out.println(object);
		}
		
		beginTransaction.commit();
	}
	
	@Test
	public void demo03() {
		Session session = HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		List<LinkMan> list = session.createQuery("from LinkMan order by lkm_id desc").list();
		for (Object object : list) {
			System.out.println(object);
		}
		
		beginTransaction.commit();
	}
	@Test
	public void demo04() {
		Session session = HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		Query query = session.createQuery("from LinkMan where lkm_id = ?");
		query.setParameter(0, 3);
		List<LinkMan> list = query.list();
		for (Object object : list) {
			System.out.println(object);
		}
		
		beginTransaction.commit();
	}
	@Test
	public void demo05() {
		try {
			Session session = HibernateUtils.openSession();
			Transaction beginTransaction = session.beginTransaction();
			List<LinkMan> list = session.createQuery("select new LinkMan(lkm_id,lkm_name) from LinkMan").list();
			for (LinkMan linkMan : list) {
				System.out.println(linkMan);
			}
			beginTransaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	@Test
	public void demo06() {
		try {
			Session session = HibernateUtils.openSession();
			Transaction beginTransaction = session.beginTransaction();
			Query query = session.createQuery("select new LinkMan(lkm_id,lkm_name) from LinkMan");
			query.setFirstResult(0);
			query.setMaxResults(8);
			List<LinkMan> list = query.list();
			for (LinkMan linkMan : list) {
				System.out.println(linkMan);
			}
			beginTransaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Test
	public void demo07() {
		try {
			Session session = HibernateUtils.openSession();
			Transaction beginTransaction = session.beginTransaction();
			Object object = session.createQuery("select count(*) from LinkMan").uniqueResult();
			System.out.println(object);
			
			beginTransaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*
	 * 多表查询
	 */
	@Test
	public void demo09() {
		try {
			Session session = HibernateUtils.openSession();
			Transaction beginTransaction = session.beginTransaction();
			Query query = session.createQuery("from Customer c inner join c.LinkMan");
			List list = query.list();
			for (Object object : list) {
				System.out.println(object);
			}
			
			beginTransaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
