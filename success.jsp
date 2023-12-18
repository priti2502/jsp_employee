<%@page import="jsp_employee.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>success</h2>
<% String name=(String) request.getAttribute("cookie");
if(name!=null)
{
%>
<h2>Changed by <%=name %></h2>	
<%} %>  


<%
List<Employee> list=(List) request.getAttribute("list");
%>
<table border=2px solid>
<tr>
   <th>Id</th>
   <th>Name</th>
   <th>Phone</th>
   <th>Address</th>
   <th>Email</th>
   <th>Password</th>
   </tr>
   <%for(Employee employee:list){ %>
   <tr>
   <td><%=employee.getId() %></td>
   <td><%=employee.getName() %></td>
   <td><%=employee.getPhone() %></td>
   <td><%=employee.getAddress() %></td>
   <td><%=employee.getEmail() %></td>
   <td><%=employee.getPassword() %></td>
   <td><a href="delete?id=<%=employee.getId()%>"><button>DELETE</button></a>
   <td><a href="update?id=<%=employee.getId()%>"><button>UPDATE</button></a>
   </tr>
   <%
   
   }
   %>

</table>

</body>
</html>