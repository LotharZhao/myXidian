package com.zhao.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.zhao.entity.Customer;
import com.zhao.entity.LinkMan;
import com.zhao.entity.Man;
import com.zhao.entity.Role;
import com.zhao.utils.HibernateUtils;

public class hibernateDemo2 {

	@Test
	public void testDeleteTable() {// 在第三张表中删除关系
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Man man = session.get(Man.class, 1);
			Role role = session.get(Role.class, 3);
			man.getSetRole().remove(role);

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
	public void testAddTable() {// 在第三张表中添加关系
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Man man = session.get(Man.class, 1);
			Role role = session.get(Role.class, 3);
			man.getSetRole().add(role);

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
	public void testSave3() {// 多对多级联保存，删除不常用
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Man man1 = new Man();
			man1.setManName("小明");
			man1.setManAge("13");
			Man man2 = new Man();
			man2.setManName("小红");
			man2.setManAge("18");

			Role role1 = new Role();
			role1.setRoleName("king");
			role1.setRoleMemo("king");
			Role role2 = new Role();
			role2.setRoleName("quern");
			role2.setRoleMemo("quern");
			Role role3 = new Role();
			role3.setRoleName("jack");
			role3.setRoleMemo("jack");

			man1.getSetRole().add(role1);
			man1.getSetRole().add(role2);
			man2.getSetRole().add(role1);
			man2.getSetRole().add(role3);

			session.save(man1);
			session.save(man2);

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
	public void testUpdate() {// 一对多修改
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1根据id查询联系人和客户
			Customer baidu = session.get(Customer.class, 4);
			LinkMan xiaohong = session.get(LinkMan.class, 2);
			// 2设置持久态对象值
			baidu.getSetLinkMan().add(xiaohong);
			xiaohong.setCustomer(baidu);

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
	public void testDelete() {// 一对多级联删除
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Customer customer = session.get(Customer.class, 1);
			session.delete(customer);

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
	public void testSave2() {// 一对多级联保存二：简化
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Customer customer = new Customer();
			customer.setCustName("sohu");
			customer.setCustLevel("svip");
			customer.setCustSource("web");
			customer.setCustPhone("87654321");

			LinkMan linkMan = new LinkMan();
			linkMan.setLkmName("小红");
			linkMan.setLkmGender("女");
			linkMan.setLkmPhone("234095");

			// 只需要在客户表示所有联系人
			customer.getSetLinkMan().add(linkMan);

			// 保存到数据库
			session.save(customer);

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
	public void testSave1() {// 一对多级联保存一
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 添加客户，并为其添加一个联系人
			// 1创建客户和联系人对象
			Customer customer = new Customer();
			customer.setCustName("baidu");
			customer.setCustLevel("vip");
			customer.setCustSource("web");
			customer.setCustPhone("12345678");

			LinkMan linkMan = new LinkMan();
			linkMan.setLkmName("小明");
			linkMan.setLkmGender("男");
			linkMan.setLkmPhone("231453");

			// 2在客户表示所有联系人，在联系人表示客户
			customer.getSetLinkMan().add(linkMan);
			linkMan.setCustomer(customer);

			// 3保存到数据库
			session.save(customer);
			session.save(linkMan);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
