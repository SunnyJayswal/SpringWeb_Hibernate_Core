<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error{
   color : red;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="enterexam" method="post" modelAttribute="examBean">
<table align="center">
<caption class="error"><h2>CREATE EXAM</h2></caption>

<tr>
<td><b>ENTER EXAM TITLE:<b></td>
<td><f:input path="examTitle" /></td>
</tr><br>

<tr>
<td><b>ENTER EXAM CODE:</b></td>
<td><f:input path="examCode"/></td>
</tr><br>


<tr>
<td><b>ENTER EXAM DATE:</b></td>
<td><f:input path="examDate"/></td>
</tr><br>

<tr>
<td><b>ENTER EXAM MARKS:</b></td>
<td><f:input path="totalMarks"/></td>
</tr><br>


<tr>
<td><b>ENTER EXAM DURATION:</b></td>
<td><f:input path="duration"/></td>
</tr><br>

<tr>
<td colspan="2"  align="center"><input type="submit" name="SUBMIT"></td>
</tr>


</table>
</f:form>

</body>
</html>