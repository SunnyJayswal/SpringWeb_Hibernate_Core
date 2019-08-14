<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%> 
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form  action="enterquestion" method="post" modelAttribute="questionBean">
<table>


<tr>
<td><b>Selct Exam:</b></td>
<td><f:select path="examBean.examId">
   <f:options itemValue="examId" items="${listOfExam}" itemLabel="examTitle"/>
</f:select></td>
</tr>


<tr>
<td><b>QuestionName:</b></td>
<td><f:input path="questionName"/></td>
</tr>


<tr>
<td><b>Question:</b></td>
<td><f:input path="question"/></td>
</tr>


<tr>
<td><b>Option1:</b></td>
<td><f:input path="optionA"/></td>
</tr>


<tr>
<td><b>Option2:</b></td>
<td><f:input path="optionB"/></td>
</tr>


<tr>
<td><b>Option3:</b></td>
<td><f:input path="optionC"/></td>
</tr>


<tr>
<td><b>Option4:</b></td>
<td><f:input path="optionD"/></td>
</tr>


<tr>
<td><b>Answer:</b></td>
<td><f:input path="answer"/></td>
</tr>

<tr>
<td><input type="submit" value="SUBMIT"></td>
</tr>

</table>
</f:form>


</body>
</html>