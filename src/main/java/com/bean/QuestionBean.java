package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "Question_Info")
public class QuestionBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;

	@NotNull
	private String question;

	@NotNull
	private String optionA;

	@NotNull
	private String optionB;

	@NotNull
	private String optionC;

	@NotNull
	private String optionD;

	@NotNull
	private String answer;
	
	@NotNull
	private String questionName;
	
	@ManyToOne
	@JoinColumn(name="examId")
	private ExamBean examBean;
		
	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public ExamBean getExamBean() {
		return examBean;
	}

	public void setExamBean(ExamBean examBean) {
		this.examBean = examBean;
	}
	
	

}
