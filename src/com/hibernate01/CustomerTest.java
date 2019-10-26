package com.hibernate01;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate01.utils.HibernateUtils;

public class CustomerTest {
	
	
	
	
	@Test
	public void Query() {
		Session session= HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		/*
		 * 面向对象
		 */
		/*try {
			org.hibernate.Query query = session.createQuery("from Customer");
			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer);
			} 
		} catch (Exception e) {
			System.out.println(e);
		}*/
		/*
		 * 接收SQL
		 */
		SQLQuery query = session.createSQLQuery("select * from cst_customer");
		List<Object[]> list = query.list();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		beginTransaction.commit();
		session.close();
	}
	
	/**  
	* @Description: delete from (这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return return_type    返回类型  
	* @throws  
	*/
	@Test
	public void Del() {
		Session session= HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		Customer customer2 = session.get(Customer.class, 3);
		session.delete(customer2);
		
		beginTransaction.commit();
		session.close();
		
	}
	
	/**  
	* @Description: Update set(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return return_type    返回类型  
	* @throws  
	*/
	@Test
	public void update() {
		Session session= HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		Customer customer2 = session.get(Customer.class, 1);
		customer2.setCust_industry("111");
		session.update(customer2);
		
		beginTransaction.commit();
		session.close();
	}
	
	/*
	 * Get与Load的区别
	 * 
	 */
	/**  
	* @Description: Load方法查询(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return return_type    返回类型  
	* @throws  
	*/
	@Test
	public void Get2() {
		Session session= HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		Customer customer = new Customer();
		Customer customer2 = session.load(Customer.class, 2);
		System.out.println(customer2);
		
		beginTransaction.commit();
		session.close();
	}
	/**  
	* @Description: Get方法查询(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return return_type    返回类型  
	* @throws  
	*/
	@Test
	public void Get1() {
		Session session= HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		Customer customer = new Customer();
		Customer customer2 = session.get(Customer.class, 2);
		System.out.println(customer2);
		
		beginTransaction.commit();
		session.close();
	}
	
	
	/**  
	* @Description: 使用事务(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return void    返回类型  
	* @throws  
	*/
	@Test
	public void Insert3() {
		Session session= HibernateUtils.getCurrentSession();
		Transaction beginTransaction = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_id(1);
		customer.setCust_name("测试3");
		
		Serializable save = session.save(customer);
		System.out.println(save);
		
		beginTransaction.commit();
	
		
	}
	
	/**  
	* @Description: 使用工具类(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return return_type    返回类型  
	* @throws  
	*/
	@Test
	public void Insert2() {
		Session session= HibernateUtils.openSession();
		Transaction beginTransaction = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_id(1);
		customer.setCust_name("测试3");
		
		Serializable save = session.save(customer);
		System.out.println(save);
		
		beginTransaction.commit();
		
		session.close();
		
	}
	

	/**  
	* @Description: 普通(这里用一句话描述这个方法的作用)  
	* @author xu_yuxin
	* @param tags    参数  
	* @return void    返回类型  
	* @throws  
	*/
	@Test
	public void Insert1() {
		
		Configuration configuration=new Configuration().configure();
		
		SessionFactory buildSessionFactory = configuration.buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		
		Transaction beginTransaction = openSession.beginTransaction();
		
		try {
			Customer customer = new Customer();
			customer.setCust_id(1);
			customer.setCust_name("测试5");
			openSession.save(customer);
			beginTransaction.commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		openSession.close();
		buildSessionFactory.close();
		
		
	}
}
