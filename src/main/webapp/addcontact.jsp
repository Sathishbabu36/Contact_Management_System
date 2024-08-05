<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addcontact</title>
<link rel="stylesheet" href="Stylesheets/login.css">
</head>
<body>

     
     <form action="addContact" method="post">
     <h2>Add Contact</h2>
     <input type="text" name="contactName" placeholder="Enter contactName">
     <input type="number" name="contactNumber" placeholder="Enter contactNumber">
     <input type="submit">
     </form>
     
      <%
      String success = (String) request.getAttribute("success");
      String failure = (String) request.getAttribute("failure");
      if(success!=null){
      %>
      <h3 style="color: green;"><%=success%></h3>
      <%} if(failure!=null){%>
      <h3 style="color: red;"><%=failure %></h3>
      <%} %>
</body>
</html>