package com.hibernate03.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	public static final Configuration CFG_CONFIGURATION;
	public static final SessionFactory SF_SESSION_FACTORY;
	
	static {
		CFG_CONFIGURATION = new Configuration().configure();
		SF_SESSION_FACTORY = CFG_CONFIGURATION.buildSessionFactory();	
					
	}
	
	public static Session openSession(){
		return SF_SESSION_FACTORY.openSession();
	}
	
	public static Session getCurrentSession() {
		return SF_SESSION_FACTORY.getCurrentSession();		
	}

}
