package com.hibernate03.test;

import org.hibernate.Session;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.hibernate03.Customer;
import com.hibernate03.LinkMan;
import com.hibernate03.utils.HibernateUtils;
import org.hibernate.Transaction;

/*
 * QBC的查询
 */
public class Demo02 {
	
	@Test
	/**
	 * 简单的查询
	 */
	public void demo1(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();	
		// 获得Criteria的对象
		Criteria criteria = session.createCriteria(LinkMan.class);
		List<LinkMan> list = criteria.list();
		
		for (LinkMan linkMan : list) {
			System.out.println(linkMan);
		}
		tx.commit();
	}
	
	@Test
	/**
	 * 排序查询
	 */
	public void demo2(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 排序查询
		Criteria criteria = session.createCriteria(LinkMan.class);
		criteria.addOrder(Order.asc("lkm_id")); // 升序
//		criteria.addOrder(Order.desc("lkm_id")); // 降序
		List<LinkMan> list = criteria.list();
		
		for (LinkMan linkMan : list) {
			System.out.println(linkMan);
		}
		tx.commit();
	}
	
	@Test
	/**
	 * 分页查询
	 */
	public void demo3(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 排序查询
		Criteria criteria = session.createCriteria(LinkMan.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(10);
		List<LinkMan> list = criteria.list();
		
		for (LinkMan linkMan : list) {
			System.out.println(linkMan);
		}
		tx.commit();
	}
	
	@Test
	/**
	 * 条件查询
	 */
	public void demo4(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 排序查询
		Criteria criteria = session.createCriteria(LinkMan.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(10);
		List<LinkMan> list = criteria.list();
		
		for (LinkMan linkMan : list) {
			System.out.println(linkMan);
		}
		tx.commit();
	}
	
	@Test
	/**
	 * 条件查询
	 */
	public void demo5(){
		try {
			Session session = HibernateUtils.getCurrentSession();
			Transaction tx = session.beginTransaction();
			// 条件查询
			Criteria criteria = session.createCriteria(LinkMan.class);
			// 设置条件:
			/**
			 * =   eq
			 * >   gt
			 * >=  ge
			 * <   lt
			 * <=  le
			 * <>  ne
			 * like
			 * in
			 * and
			 * or
			 */
			criteria.add(Restrictions.eq("lkm_id", "3"));
			//		criteria.add(Restrictions.or(Restrictions.like("cust_name", "李%")));
			//		criteria.add(Restrictions.like("cust_name", "李%"));
			List<LinkMan> list = criteria.list();
			for (LinkMan linkMan : list) {
				System.out.println(linkMan);
			}
			tx.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Test
	/**
	 * 统计查询
	 */
	public void demo6(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(LinkMan.class);
		/**
		 * add				:普通的条件。where后面条件
		 * addOrder			:排序
		 * setProjection	:聚合函数 和 group by having
		 */
		criteria.setProjection(Projections.rowCount());
		Long num = (Long) criteria.uniqueResult();
		System.out.println(num);
		tx.commit();
	}
	
	
	
	
	
	
	
	
	
	

}
