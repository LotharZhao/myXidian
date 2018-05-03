package com.zhao.demo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.zhao.entity.User;
import com.zhao.utils.HibernateUtils;

public class HibernateDemo {

	@Test
	public void testSQLQuery() {// SQLQuery��ѯ
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// 1����SQlQuery����
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
			// 2�õ�sqlQuery�Ľ��
//			List<Object[]> list = sqlQuery.list();// ���ص��Ƕ�������
//			for(Object[] objects : list){
//				System.out.println(Arrays.toString(objects));
//			}
			sqlQuery.addEntity(User.class);// �����ɶ���
			List<User> list = sqlQuery.list();
			for(User user : list){
				System.out.println(user);
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testCriteria() {// Criteria��ѯ
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// 1����Criteria����
			Criteria criteria = session.createCriteria(User.class);
			// 2�õ�Criteria�Ľ��
			List<User> list = criteria.list();
			for(User user : list){
				System.out.println(user);
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testQuery() {// Query��ѯ
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// 1����Query����
			Query query = session.createQuery("from User");
			// 2�õ�query�Ľ��
			List<User> list = query.list();
			for(User user : list){
				System.out.println(user);
			}
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testSession() {// �����̰߳�session
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 1);
			System.out.println(user);
			
			tx.commit();// �ύ����
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();// �ع�����
		} finally {
//			session.close();
		}
	}

	@Test
	public void testTx() {// ����淶д��
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 1);
			System.out.println(user);
			
			int i = 10/0;// ģ���쳣
			
			tx.commit();// �ύ����
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();// �ع�����
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testCasch2(){// һ����������
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 6);
		user.setPwd("abcde");
//		session.update(user);
		
		tx.commit();
		session.close();
	}

	@Test
	public void testCasch(){// ��֤һ������
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		User user1 = session.get(User.class, 6);
		System.out.println(user1);
		User user2 = session.get(User.class, 6);
		System.out.println(user2);
		
		tx.commit();
		session.close();
	}

	@Test
	public void testSaveorUpdate() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		user.setUid(7);
		user.setUsername("С��");
		user.setPwd("5678");
		user.setAddress("�Ϻ�");
		session.saveOrUpdate(user); 
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void testDelete() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		// ɾ�� ��һ�ַ�ʽ
//		User user = session.get(User.class, 3);
//		session.delete(user);
		
		// �ڶ���
		User user = new User();
		user.setUid(4);
		session.delete(user);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void testUpdate() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		// �޸ı�
		// 1����id��ѯ
		User user = session.get(User.class, 2);
		// 2��user���޸�ֵ
		user.setPwd("6789");
		// 3����Session��update����
		session.update(user);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void testSelect() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		// ����id��ѯ
		// ����Session��get��������һ��������ʵ�����class �ڶ���������idֵ
		User user = session.get(User.class, 1);
		System.out.println(user);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void testInsert() {
		// 1.���غ��������ļ�
//		Configuration cfg = new Configuration();
//		cfg.configure();
		// 2.����SessionFactory����
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		// 3.����session
		Session session = sessionFactory.openSession();
		// 4.��������
		Transaction tx = session.beginTransaction();

		// 5.д�����߼� crud����
		User user = new User();
		user.setUsername("С��");
		user.setPwd("1234");
		user.setAddress("����");
		session.save(user);

		// 6.�ύ����
		tx.commit();
		// 7.�ر���Դ
		session.close();
		sessionFactory.close();
	}
}
