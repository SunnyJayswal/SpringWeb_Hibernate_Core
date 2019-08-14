<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bean.ExamBean"%>
<%@page import="com.bean.QuestionBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<f:form action="userexamdata" method="post" modelAttribute="bean">
		<table align="center" border="1">
	
				<tr>
					<td colspan="3" align="center">
						<h2>${bean.beans[0].examBean.examTitle}</h2>
					</td>
				</tr> 
				<tr>
				   <td align="left"><h4>Marks: ${bean.beans[0].examBean.totalMarks}</h4></td>
					<td align="right"><h4>Duration: ${bean.beans[0].examBean.duration}</h4></td>
					<td align="center"><h4>Date: ${bean.beans[0].examBean.examDate}</h4></td>
				</tr>
			
	<c:forEach items="${bean.beans}" var="i" varStatus="status">
		        <tr>
		          <input type="hidden" name="beans[${status.index}].examBean.examId" value="${i.examBean.examId}"/>
				   <input type="hidden" name="beans[${status.index}].userBean.userId" value="${i.userBean.userId}"/>
				<input type="hidden" name="beans[${status.index}].questionBean.questionId" value="${i.questionBean.questionId}"/>
				<input type="hidden" name="beans[${status.index}].questionBean.answer" value="${i.questionBean.answer}"/>
					<td colspan="3"><h3>Question: ${i.questionBean.question}</h3> 
					<input type="radio" name="beans[${status.index}].answerOfUser" value="1" />${i.questionBean.optionA}<br>
						<input type="radio" name="beans[${status.index}].answerOfUser" value="2" />${i.questionBean.optionB}<br>
						<input type="radio" name="beans[${status.index}].answerOfUser" value="3" />${i.questionBean.optionC}<br>
						<input type="radio" name="beans[${status.index}].answerOfUser" value="4" />${i.questionBean.optionD}<br>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="Submit"> <input type="reset" value="Reset"></td>
			</tr> 
		</table>
	</f:form>
</body>
</html>