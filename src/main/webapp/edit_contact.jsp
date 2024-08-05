<%@page import="com.practice.entity.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
m
       <%Contact contact=(Contact)request.getAttribute("contact");%>
        <form action="update_contact" method="post">
        <h1>Update Contact</h1>
        <input name="contactId" type="text" value="<%=contact.getContactId()%>" readonly="readonly" hidden="true">
        <input name="contactName" type="text" value="<%=contact.getContactName()%>">
        <input name="contactNumber" type="text" value="<%=contact.getContactNum()%>">
        <input type="submit" value="confirm">
        </form>
</body>
</html>