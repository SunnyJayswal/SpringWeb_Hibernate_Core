package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.bean.UserBean;
import com.bean.UserExamBean;
import com.dao.ExamDao;
import com.dao.UserDao;

@Controller
public class ExamController {
	@Autowired
	ExamDao examDao;

	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/examcodepage", method = RequestMethod.GET)
	public String loadExam(Model model) {

		ExamBean examBean = new ExamBean();
		model.addAttribute("examBean", examBean);
		return "examcode";

	}

	@RequestMapping(value = "/examdata", method = RequestMethod.POST)
	public String examData(@ModelAttribute ExamBean examBean, HttpSession httpSession) {

		String code = examBean.getExamCode();
		examBean = examDao.search(code);
		int userId = (Integer) httpSession.getAttribute("userId");
		UserBean userBean = userDao.searchUser(userId);
		if (examBean != null) {
			int examId = examBean.getExamId();
			List<QuestionBean> questions = examDao.searchQuestions(examId);
			List<UserExamBean> listOfUserExam = new ArrayList<UserExamBean>();
			for (QuestionBean questionBean : questions) {

				UserExamBean userExamBean = new UserExamBean();
				userExamBean.setQuestionBean(questionBean);
				userExamBean.setExamBean(examBean);
				userExamBean.setUserBean(userBean);
				listOfUserExam.add(userExamBean);
			}
			httpSession.setAttribute("listOfUserExam", listOfUserExam);
			examBean.setQuestions(questions);
			httpSession.setAttribute("examObj", examBean);
			httpSession.setAttribute("examId", examId);
			System.out.println("+++++ID++++" + examId);
			return "redirect:/userexam";
		} else {
			return "examcode";
		}
	}
}
