package com.zhao.demo;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.zhao.entity.Customer;
import com.zhao.entity.LinkMan;
import com.zhao.utils.HibernateUtils;

public class HibernateDemo3 {

	@Test
	public void testDemo() {// 批量抓取优化
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Customer.class);
			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid()+":"+customer.getCustName());
				Set<LinkMan> setL = customer.getSetLinkMan();
				for(LinkMan linkMan : setL){
					System.out.println(linkMan.getLkmName());
				}
			}
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session.isOpen())
				session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testLoad() {// load
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Customer customer = session.load(Customer.class, 4);
			System.out.println("cid:" + customer.getCid());

			Set<LinkMan> linkMans = customer.getSetLinkMan();
			// 发送语句
			System.out.println(linkMans.size());

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session.isOpen())
				session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testInner() {// HQL迫切内连接、其他略
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Query query = session
					.createQuery("from Customer c inner join fetch c.setLinkMan");

			List list = query.list();

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session.isOpen())
				session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testQBC6() {// qbc查询：离线查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			DetachedCriteria detachedCriteria = DetachedCriteria
					.forClass(Customer.class);
			Criteria criteria = detachedCriteria.getExecutableCriteria(session);

			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid() + ":"
						+ customer.getCustName());
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session.isOpen())
				session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testQBC5() {// qbc查询：统计查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Customer.class);
			criteria.setProjection(Projections.rowCount());

			Object object = criteria.uniqueResult();
			Long lobj = (Long) object;
			int count = lobj.intValue();
			System.out.println(count);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session.isOpen())
				session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testQBC4() {// qbc查询：分页查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Customer.class);
			criteria.addOrder(Order.desc("cid"));

			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid() + ":"
						+ customer.getCustName());
			}

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session.isOpen())
				session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testQBC3() {// qbc查询：排序查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Customer.class);
			criteria.setFirstResult(0);
			criteria.setMaxResults(3);

			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid() + ":"
						+ customer.getCustName());
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
	public void testQBC2() {// qbc查询：条件查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Criteria criteria = session.createCriteria(Customer.class);
			criteria.add(Restrictions.eq("custLevel", "vip"));
			criteria.add(Restrictions.like("custName", "%b%"));

			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid() + ":"
						+ customer.getCustName());
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
	public void testQBC1() {// qbc查询：查詢所有
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			// 1创建对象
			Criteria criteria = session.createCriteria(Customer.class);
			// 2调用方法得到结果
			List<Customer> list = criteria.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid() + ":"
						+ customer.getCustName());
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
	public void testHQL6() {// hql查询：聚集函数使用
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("select count(*) from Customer");
			Object object = query.uniqueResult();

			Long lobj = (Long) object;
			int count = lobj.intValue();
			System.out.println(count);

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
	public void testHQL5() {// hql查询：投影查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("select custName from Customer");

			List<Object> list = query.list();
			for (Object object : list) {
				System.out.println(object);
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
	public void testHQL4() {// hql查询：分页查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from Customer");
			query.setFirstResult(0);
			query.setMaxResults(3);

			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid() + ":"
						+ customer.getCustName());
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
	public void testHQL3() {// hql查询：排序查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Query query = session
					.createQuery("from Customer order by cid desc");// 升序：asc/降序：desc

			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer.getCid() + ":"
						+ customer.getCustName());
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
	public void testHQL2() {// hql查询：条件查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Query query = session
					.createQuery("from Customer where custLevel=? and custName like ?");
			query.setParameter(0, "vip");
			query.setParameter(1, "%b%");

			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer.getCustName());
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
	public void testHQL1() {// hql查询：查询所有
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Query query = session.createQuery("from Customer");
			List<Customer> list = query.list();
			for (Customer customer : list) {
				System.out.println(customer.getCustName());
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
	public void testOid() {// oid查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Customer customer = session.get(Customer.class, 2);
			System.out.println(customer);

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
	public void testSelect1() {// 对象导航查询
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();

			Customer customer = session.get(Customer.class, 1);
			Set<LinkMan> linkMan = customer.getSetLinkMan();
			System.out.println(linkMan.size());

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
