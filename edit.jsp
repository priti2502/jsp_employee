<%@page import="jsp_employee.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Employee  employee=(Employee) request.getAttribute("emp"); 
%>

<form action="edit" method="post">
Id:<input type="hidden" name="id" value=<%=employee.getId()%> readonly="true">
Name:<input type="text" name="name" value=<%=employee.getName()%>>
Phone:<input type="tel" name="phone" value=<%=employee.getPhone()%>>
Address:<input type="text" name="address" value=<%=employee.getAddress()%>>
Email:<input type="text" name="email" value=<%=employee.getEmail()%>>
Password:<input type="text" name="password" value=<%=employee.getPassword()%>>
<button>UPDATE</button>





</form>
</body>
</html>