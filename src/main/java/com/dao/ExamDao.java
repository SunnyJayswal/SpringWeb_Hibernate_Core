package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.ExamBean;
import com.bean.QuestionBean;

@Repository
public class ExamDao {
	@Autowired
	SessionFactory factory;

	public ExamBean search(String code) {

		Session session = factory.openSession();

		Query query = session.createQuery("from ExamBean where examCode =:code");
		query.setParameter("code", code);
		List<ExamBean> list = query.list();

		session.close();
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}

	}

	public List<QuestionBean> searchQuestions(int Id) {

		Session session = factory.openSession();

		Query query = session.createQuery("from QuestionBean where examId = :Id");

		query.setParameter("Id", Id);

		List<QuestionBean> listObj = query.list();

		session.close();

		return listObj;

	}

}
