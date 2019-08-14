package com.dao;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.AdminBean;
import com.bean.ExamBean;
import com.bean.QuestionBean;

@Repository
public class AdminDao {
	@Autowired
	SessionFactory factory;

	public AdminBean verifyAdmin(String userName, String password) {

		Session session = factory.openSession();
		Query query = session.createQuery("from AdminBean where userName=:userName AND password=:password");
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		List<AdminBean> list = query.list();
		session.close();

		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}

	}

	public void insertExam(ExamBean examBean) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.saveOrUpdate(examBean);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public List<ExamBean> search() {

		Session session = factory.openSession();
		Query query = session.createQuery("from ExamBean");
		List<ExamBean> list = query.list();
		session.close();
		return list;
	}

	public void insertQuestions(QuestionBean questionBean) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		try {
			session.save(questionBean);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}

	}

	public QuestionBean searchById(int questionId) {

		Session session = factory.openSession();
		QuestionBean questionBean = session.get(QuestionBean.class, questionId);
		session.close();
		return questionBean;
	}

	public void deleteQuestion(QuestionBean questionBean) {

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			if (questionBean != null) {
				session.delete(questionBean);
				transaction.commit();
			}
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
	}

	public ExamBean searchByExamId(int examId) {

		Session session = factory.openSession();
		ExamBean examBean = session.get(ExamBean.class, examId);
		session.close();
		return examBean;

	}

}
