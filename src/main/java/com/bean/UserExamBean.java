package com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="UserExam_Info")
public class UserExamBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ueId;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="userId")
	private UserBean userBean;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="examId")
	private ExamBean examBean;

	@NotNull
	@ManyToOne 
	@JoinColumn(name="questionId")
	private QuestionBean questionBean;
	
	@NotNull
	private String answerOfUser;
	
	@NotNull
	private boolean status;

	public int getUeId() {
		return ueId;
	}

	public void setUeId(int ueId) {
		this.ueId = ueId;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public ExamBean getExamBean() {
		return examBean;
	}

	public void setExamBean(ExamBean examBean) {
		this.examBean = examBean;
	}

	public QuestionBean getQuestionBean() {
		return questionBean;
	}

	public void setQuestionBean(QuestionBean questionBean) {
		this.questionBean = questionBean;
	}


	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAnswerOfUser() {
		return answerOfUser;
	}

	public void setAnswerOfUser(String answerOfUser) {
		this.answerOfUser = answerOfUser;
	}
	
	

}
