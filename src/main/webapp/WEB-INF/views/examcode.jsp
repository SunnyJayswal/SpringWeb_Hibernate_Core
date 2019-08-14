<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error{
 color: red;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:form action="examdata" method="post" modelAttribute="examBean">
<table align="center">
<tr>
<td><h1>Enter Exam Code:</h1></td><td><f:input path="examCode"/></td>
</tr>
<tr><td align="right"><input type="submit" name="SUBMIT"></td></tr>

</table>
</f:form>
</body>
</html>