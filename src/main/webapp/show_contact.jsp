<%@page import="com.practice.entity.Contact"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="navbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      <%List<Contact> contacts=(List<Contact>)request.getAttribute("contacts"); %>
      
      
      <table>
          <tr>
              
             <th>Contact_Name</th>
             <th>Contact_Number</th>
             <th>Edit</th>
             <th>Delete</th>
             
          </tr>
          
          <% 
          if(contacts!=null){
          for(Contact contact:contacts){
          %>
          <tr>
             <td><%=contact.getContactName() %></td>
             <td><%=contact.getContactNum() %></td>
             <td><a href="load_contact?contactId=<%=contact.getContactId()%>">edit</a></td>
             <td><a href="delete_contact?contactId=<%=contact.getContactId()%>">delete</a></td>
           </tr>  
      <%}}%>
      
      </table>
</body>
</html>