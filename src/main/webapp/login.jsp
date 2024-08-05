<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login page</title>
<link rel="stylesheet" href="Stylesheets/login.css">
</head>
<body>

      <%String msg = (String) request.getAttribute("error"); 
      if(msg!=null){
      %>
      <h4 style="color: red"><%=msg %></h4>
      
      <%} %>
      
      <form action="login" method="post">
      <h2>login</h2>
      <input type="email" name="email" placeholder="Enter email">
      <input type="password" name="password" placeholder="Enter password"><br>
      <input type="submit" value="login">
      </form>
</body>
</html>