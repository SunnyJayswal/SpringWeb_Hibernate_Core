package com.controller;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.ExamBean;
import com.bean.UserBean;
import com.dao.UserDao;

@Controller
public class UserController {
	@Autowired
	UserDao userDao;

	@RequestMapping(value = "/signupuser", method = RequestMethod.GET)
	public String loadUser(Model model) {

		UserBean userBean = new UserBean();
		model.addAttribute("userBean", userBean);
		return "signup";

	}

	@RequestMapping(value = "/insertuser", method = RequestMethod.POST)
	public String insertUser(@ModelAttribute("userBean") @Validated UserBean userBean, BindingResult result,
			Model model, HttpSession httpSession) {

		if (result.hasErrors()) {
			return "signup";
		} else {
			userDao.insertUser(userBean);
			int userId = userBean.getUserId();
			httpSession.setAttribute("userId", userId);
			model.addAttribute("userBean", userBean);
			return "redirect:/examcodepage";
		}
	}

}
