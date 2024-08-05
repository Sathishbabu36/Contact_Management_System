
<%@page import="com.practice.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome page</title>
<link rel="stylesheet" href="Stylesheets/style.css">
</head>
<body>
     <%
      User user1 = (User) session.getAttribute("user");
      String addcontacts = (user1 != null)?"addcontact.jsp":"login.jsp";
      String managecontacts = (user1 != null)?"show_contact":"login.jsp";
      String manageaccount = (user1 != null)?"manageaccount.jsp":"login.jsp";
     %>
     
     <div id="index">
     <h1>Welcome</h1>
     <button><a href="<%=addcontacts%>">AddContact</a></button>
     <button><a href="<%=managecontacts%>">ManageContact</a></button>
     <button><a href="<%=manageaccount%>">ManageAccount</a></button>
     </div>
</body>
</html>