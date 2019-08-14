<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center">
<caption><h2>Questions</h2></caption>

<tr>
<td><b>Question</b></td>
<td><b>Option A</b></td>
<td><b>Option B</b></td>
<td><b>Option C</b></td>
<td><b>Option D</b></td>
<td><b>Answer</b></td>
<td><b>Action</b></td>
</tr>

<c:forEach items="${questions}" var="q">
<tr>
<td>${q.question}</td>
<td>${q.optionA}</td>
<td>${q.optionB}</td>
<td>${q.optionC}</td>
<td>${q.optionD}</td>
<td>${q.answer}</td>
<td><a href="../deletequestion/${q.questionId}"><button>DELETE</button></a></td>
</tr>
</c:forEach>

</table>


</body>
</html>