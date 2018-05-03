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
	public void testDeleteTable() {// �ڵ����ű���ɾ����ϵ
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
	public void testAddTable() {// �ڵ����ű�����ӹ�ϵ
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
	public void testSave3() {// ��Զ༶�����棬ɾ��������
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Man man1 = new Man();
			man1.setManName("С��");
			man1.setManAge("13");
			Man man2 = new Man();
			man2.setManName("С��");
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
	public void testUpdate() {// һ�Զ��޸�
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// 1����id��ѯ��ϵ�˺Ϳͻ�
			Customer baidu = session.get(Customer.class, 4);
			LinkMan xiaohong = session.get(LinkMan.class, 2);
			// 2���ó־�̬����ֵ
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
	public void testDelete() {// һ�Զ༶��ɾ��
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
	public void testSave2() {// һ�Զ༶�����������
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
			linkMan.setLkmName("С��");
			linkMan.setLkmGender("Ů");
			linkMan.setLkmPhone("234095");

			// ֻ��Ҫ�ڿͻ���ʾ������ϵ��
			customer.getSetLinkMan().add(linkMan);

			// ���浽���ݿ�
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
	public void testSave1() {// һ�Զ༶������һ
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			// ��ӿͻ�����Ϊ�����һ����ϵ��
			// 1�����ͻ�����ϵ�˶���
			Customer customer = new Customer();
			customer.setCustName("baidu");
			customer.setCustLevel("vip");
			customer.setCustSource("web");
			customer.setCustPhone("12345678");

			LinkMan linkMan = new LinkMan();
			linkMan.setLkmName("С��");
			linkMan.setLkmGender("��");
			linkMan.setLkmPhone("231453");

			// 2�ڿͻ���ʾ������ϵ�ˣ�����ϵ�˱�ʾ�ͻ�
			customer.getSetLinkMan().add(linkMan);
			linkMan.setCustomer(customer);

			// 3���浽���ݿ�
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
