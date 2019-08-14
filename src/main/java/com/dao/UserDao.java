package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	SessionFactory factory;

	public UserBean insertUser(UserBean userBean) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		try {

			session.save(userBean);

			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
		}
		session.close();
		return userBean;

	}

	public UserBean searchUser(int userId) {

		Session session = factory.openSession();
		UserBean userBean = session.get(UserBean.class, userId);
		session.close();
		return userBean;
	}

}
