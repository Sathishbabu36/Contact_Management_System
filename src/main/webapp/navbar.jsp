<%@page import="com.practice.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>contact management system</title>
<link rel="stylesheet" href="Stylesheets/navbar.css">
</head>
<body>
	<%User user = (User) session.getAttribute("user"); %>
	<%--   <div class="header">
     
     <nav>
     <h1>Contact Management System</h1>
     
     <%if(user==null){ %>
      <button> <a href="register.jsp"></a>  Register</button>
      <button> <a href="login.jsp"></a>  Login</button
     <%} if(user!=null) { %>
     <button><a href=""></a>logout </button>
     <%} %>
     
     </nav>
     </div> --%>

	<nav>
		<span>Contact Management System</span>
		<%if (user==null){ %>
           <button> <span><a href="register.jsp" >Register</a></span> </button>
           <button> <span><a href="login.jsp" >Login</a></span> </button>
           
           <%} else { %>
           <button> <span><a href="logout" >Logout</a></span> </button>
           <%} %>
           <button> <span><a href="index.jsp" >home</a></span> </button>
           
	</nav>












</body>
</html>