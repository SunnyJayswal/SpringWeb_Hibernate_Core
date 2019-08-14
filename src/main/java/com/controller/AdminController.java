package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.AdminBean;
import com.bean.ExamBean;
import com.bean.QuestionBean;
import com.dao.AdminDao;
import com.dao.ExamDao;

@Controller
public class AdminController {
	@Autowired
	AdminDao adminDao;

	@Autowired
	ExamDao examDao;

	@RequestMapping(value = "/loadlogin", method = RequestMethod.GET)
	public String loadLogin(@ModelAttribute AdminBean adminBean) {

		return "adminlogin";

	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String adminLogin(@ModelAttribute AdminBean adminBean, HttpSession httpSession) {

		String userName = adminBean.getUserName();
		String password = adminBean.getPassword();

		httpSession.setAttribute("userName", userName);
		httpSession.setAttribute("password", password);

		AdminBean admin = adminDao.verifyAdmin(userName, password);

		if (admin != null) {
			return "adminpage";
		} else {
			String errorMessage = "Please enter valid Username or Password";
			httpSession.setAttribute("errorMessage", errorMessage);
			return "redirect:/loadlogin";
		}

	}

	@RequestMapping(value = "/createexam", method = RequestMethod.GET)
	public String createExam(@ModelAttribute ExamBean examBean) {

		return "createexam";
	}

	@RequestMapping(value = "/enterexam", method = RequestMethod.POST)
	public String enterExam(@ModelAttribute ExamBean examBean) {

		adminDao.insertExam(examBean);

		return "redirect:/createexam";
	}

	@RequestMapping(value = "/loadquestion", method = RequestMethod.GET)
	public String loadQuestions(@ModelAttribute QuestionBean questionBean, Model model) {

		List<ExamBean> examBeans = adminDao.search();

		model.addAttribute("listOfExam", examBeans);

		return "addquestion";
	}

	@RequestMapping(value = "/enterquestion", method = RequestMethod.POST)
	public String addQuestions(@ModelAttribute QuestionBean questionBean) {

		if (questionBean != null) {
			adminDao.insertQuestions(questionBean);
		}
		return "redirect:/loadquestion";

	}

	@RequestMapping(value = "/showexam", method = RequestMethod.GET)
	public String showExam(@ModelAttribute ExamBean examBean, HttpSession httpSession, Model model) {

		List<ExamBean> exams = adminDao.search();
		model.addAttribute("exams", exams);
		return "showexam";
	}

	@RequestMapping(value = "/showquestion/{examId}", method = RequestMethod.GET)
	public String showQuestion(@PathVariable("examId") int examId, Model model) {

		List<QuestionBean> questions = examDao.searchQuestions(examId);

		model.addAttribute("questions", questions);

		return "showquestion";
	}

	@RequestMapping(value = "/deletequestion/{questionId}", method = RequestMethod.GET)
	public String deleteQuestion(@PathVariable("questionId") int questionId) {

		QuestionBean questionBean = adminDao.searchById(questionId);

		int examId = questionBean.getExamBean().getExamId();

		adminDao.deleteQuestion(questionBean);

		return "redirect:/showquestion/" + examId + "";

	}

	@RequestMapping(value = "/updateexam/{examId}", method = RequestMethod.GET)
	public String updateExam(@ModelAttribute ExamBean examBean, @PathVariable("examId") int examId, Model model) {

		examBean = adminDao.searchByExamId(examId);

		model.addAttribute("examBean", examBean);

		return "updateexam";

	}

	@RequestMapping(value = "updateexamdata")
	public String updateExamData(@ModelAttribute ExamBean examBean) {

		adminDao.insertExam(examBean);

		return "redirect:/showexam";

	}

}
