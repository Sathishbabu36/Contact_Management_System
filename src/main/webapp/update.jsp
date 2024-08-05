<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file = "navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update user</title>
<link rel="stylesheet" href="Stylesheets/update_contact.css">
</head>
<body>

      <h2>update</h2>
     <%
      user = (User) session.getAttribute("user");
      Integer userId = (user!=null)?user.getUserId():0;
      String userName = (user!=null)? user.getUserName():"";
      String email = (user!=null)? user.getEmail():"";
      String password = (user!=null)? user.getPassword():"";
      
      String success = (String) request.getAttribute("success");
      String failure = (String) request.getAttribute("failure");
      if(success != null){
     %>
     <h4 style="color: green"><%=success %></h4>
     <%} if(failure != null){%>
     <h4 style="color: red;"><%=failure %></h4>
     <%} %>
     
     <form action="update" method="post">
     <input type="number" name="userId" value="<%=userId%>" readonly="readonly" hidden="true">
     <input type="text" name="userName" value="<%=userName%>">
     <input type="email" name="email" value="<%=email%>"> 
     <input type="password" name="password" value="<%=password%>">    
     <input type="submit" placeholder="update">
     </form>
</body>
</html>