package com.zhao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static Configuration cfg = null;
	private static SessionFactory sessionFactory = null;
	static {
		// 1.加载核心配置文件
		cfg = new Configuration();
		cfg.configure();
		// 2.创建SessionFactory对象
		sessionFactory = cfg.buildSessionFactory();
	}

	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
