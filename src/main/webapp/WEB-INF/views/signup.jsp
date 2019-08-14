<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.error {
	color: red;
}
.colour{
    color: blue;
    size: px;
}
</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<f:form action="insertuser" method="post" modelAttribute="userBean">
<table align="center">
<caption><h1><font color="green">Signup</font></h1></caption>
<tr><td class="colour">UserName:</td><td><f:input path="userName" /><f:errors path="userName" cssClass="error"></f:errors></td></tr><br>
<tr><td class="colour">Email Id:</td><td><f:input path="email" /><f:errors path="email" cssClass="error"></f:errors></td></tr><br>
<tr><td class="colour">Password:</td><td><f:input path="password" /><f:errors path="password" cssClass="error"></f:errors></td></tr><br>
<tr><td colspan="2" align="center"><input type="submit" name="SUBMIT"></td></tr>
</table>
</f:form>

</body>
</html>