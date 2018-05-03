package com.zhao.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static Configuration cfg = null;
	private static SessionFactory sessionFactory = null;
	static {
		// 1.���غ��������ļ�
		cfg = new Configuration();
		cfg.configure();
		// 2.����SessionFactory����
		sessionFactory = cfg.buildSessionFactory();
	}

	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
