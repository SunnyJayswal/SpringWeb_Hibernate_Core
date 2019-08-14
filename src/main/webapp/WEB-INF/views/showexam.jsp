<%@ page language="java" isELIgnored="false"  contentType="text/html; charset=ISO-8859-1"
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
<table  align="center"  border="1">
<caption><h2>Exams</h2></caption>

<tr>
<td><b>Subject</b></td>
<td><b>Date</b></td>
<td><b>Marks</b></td>
<td><b>Duration</b></td>
<td><b>Action</b></td>
</tr>

<c:forEach items="${exams}" var="e">
<tr>
<td>${e.examTitle}</td>
<td>${e.examDate}</td>
<td>${e.totalMarks}</td>
<td>${e.duration}</td>
<td><a href="showquestion/${e.examId}"><button>SEE QUESTIONS</button></a>
    <a href="updateexam/${e.examId}"><button>UPDATE EXAM</button></a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>