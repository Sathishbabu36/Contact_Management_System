<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register here</title>
<link rel="stylesheet" href="Stylesheets/login.css">
</head>
<body>

    <form action="register" method="post">
        <h2>Register</h2>
      <input type="text" name="userName" placeholder="Enter userName"><br>
      <input type="email" name="email" placeholder="Enter email"><br>
      <input type="password" name="password" placeholder="Enter Password"><br>
      <input type="submit">
     </form>

<%
 String message = (String) request.getAttribute("message");
 if(message!=null){
%>
<h4 style="color: red;"><%=message %></h4>
<%} %>
</body>
</html>