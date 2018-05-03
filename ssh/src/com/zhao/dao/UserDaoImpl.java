package com.zhao.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.zhao.entity.User;

public class UserDaoImpl implements UserDao {

	// µÃµ½hibernateTemplate
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void add() {
		User user = new User();
		user.setUsername("zzz");
		user.setAddress("usa");

		hibernateTemplate.save(user);
	}

	@Override
	public void select() {
		User user = hibernateTemplate.get(User.class, 2);
		System.out.println(user);
	}

	@Override
	public void findAll() {
		List<User> list = (List<User>) hibernateTemplate.find("from User");
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Override
	public void findByName() {
		List<User> list = (List<User>) hibernateTemplate.find("from User where username=?", "lucy");
		for (User user : list) {
			System.out.println(user);
		}
	}
}
