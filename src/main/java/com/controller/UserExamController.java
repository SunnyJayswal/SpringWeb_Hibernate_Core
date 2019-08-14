package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.ExamBean;
import com.bean.ListUserExamBean;
import com.bean.QuestionBean;
import com.bean.UserBean;
import com.bean.UserExamBean;
import com.dao.UserExamDao;

@Controller
public class UserExamController {
	@Autowired
	UserExamDao dao;

	@RequestMapping(value = "/userexam", method = RequestMethod.GET)
	public String loadExam1(Model model, HttpSession httpSession) {

		List<UserExamBean> list = (List<UserExamBean>) httpSession.getAttribute("listOfUserExam");
		ListUserExamBean beans = new ListUserExamBean();
		beans.setBeans(list);
		model.addAttribute("bean", beans);
		return "questions";

	}

	@RequestMapping(value = "/userexamdata", method = RequestMethod.POST)
	public String userExam(@ModelAttribute ListUserExamBean bean, HttpSession httpSession, Model model) {

		List<UserExamBean> beans = bean.getBeans();

		int questionCount = 0;
		int trueCount = 0;
		String message = null;

		for (UserExamBean uebean : beans) {

			int questionId = uebean.getQuestionBean().getQuestionId();
			String answer = uebean.getQuestionBean().getAnswer();
			String answerOfUser = uebean.getAnswerOfUser();
			int userId = uebean.getUserBean().getUserId();
			int examId = uebean.getExamBean().getExamId();
			questionCount++;

			if (answer.equalsIgnoreCase(answerOfUser)) {
				trueCount++;
				uebean.setStatus(true);
			} else {
				uebean.setStatus(false);
			}

			dao.insert(uebean);

		}

		if (trueCount >= (questionCount / 2)) {
			message = "Congratulations! You have passed this exam";
		} else {
			message = "Sorry! You have not cleared this exam";
		}

		model.addAttribute("message", message);

		return "success";

	}
}
