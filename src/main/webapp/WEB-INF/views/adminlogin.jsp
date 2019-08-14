<%@ page language="java" isELIgnored="false"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.colour{
   color: blue;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
     String errorMessage=(String)session.getAttribute("errorMessage");
%>

<f:form action="adminlogin" method="post" modelAttribute="adminBean">
<table  align="center">
<caption><h2><font color="green">Admin Login</font></h2></caption><br><br>
<tr>
<th class="colour">Username</th>
<td><f:input path="userName"/></td>     
</tr>
<tr>
<th class="colour">Password</th>
<td><f:password path="password"/></td>
</tr>
<tr>
<td><input type="submit" name="SUBMIT"/></td>
</tr>
</table>
</f:form>
<%
if(errorMessage!=null){
out.println(errorMessage);
}
%>
</body>
</html>