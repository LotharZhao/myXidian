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
	public void testSQLQuery() {// SQLQuery查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// 1创建SQlQuery对象
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
			// 2得到sqlQuery的结果
//			List<Object[]> list = sqlQuery.list();// 返回的是对象数组
//			for(Object[] objects : list){
//				System.out.println(Arrays.toString(objects));
//			}
			sqlQuery.addEntity(User.class);// 数组变成对象
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
	public void testCriteria() {// Criteria查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// 1创建Criteria对象
			Criteria criteria = session.createCriteria(User.class);
			// 2得到Criteria的结果
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
	public void testQuery() {// Query查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			// 1创建Query对象
			Query query = session.createQuery("from User");
			// 2得到query的结果
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
	public void testSession() {// 本地线程绑定session
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 1);
			System.out.println(user);
			
			tx.commit();// 提交事务
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();// 回滚事务
		} finally {
//			session.close();
		}
	}

	@Test
	public void testTx() {// 事务规范写法
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			User user = session.get(User.class, 1);
			System.out.println(user);
			
			int i = 10/0;// 模拟异常
			
			tx.commit();// 提交事务
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();// 回滚事务
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testCasch2(){// 一级缓存特性
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		User user = session.get(User.class, 6);
		user.setPwd("abcde");
//		session.update(user);
		
		tx.commit();
		session.close();
	}

	@Test
	public void testCasch(){// 验证一级缓存
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
		user.setUsername("小智");
		user.setPwd("5678");
		user.setAddress("上海");
		session.saveOrUpdate(user); 
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void testDelete() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		// 删除 第一种方式
//		User user = session.get(User.class, 3);
//		session.delete(user);
		
		// 第二种
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
		// 修改表
		// 1根据id查询
		User user = session.get(User.class, 2);
		// 2向user中修改值
		user.setPwd("6789");
		// 3调用Session的update方法
		session.update(user);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void testSelect() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		// 根据id查询
		// 调用Session的get方法：第一个参数：实体类的class 第二个参数：id值
		User user = session.get(User.class, 1);
		System.out.println(user);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void testInsert() {
		// 1.加载核心配置文件
//		Configuration cfg = new Configuration();
//		cfg.configure();
		// 2.创建SessionFactory对象
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		// 3.创建session
		Session session = sessionFactory.openSession();
		// 4.开启事务
		Transaction tx = session.beginTransaction();

		// 5.写具体逻辑 crud操作
		User user = new User();
		user.setUsername("小刚");
		user.setPwd("1234");
		user.setAddress("重庆");
		session.save(user);

		// 6.提交事务
		tx.commit();
		// 7.关闭资源
		session.close();
		sessionFactory.close();
	}
}
