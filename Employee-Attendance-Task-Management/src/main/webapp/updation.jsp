<%@page import="jakarta.servlet.http.HttpSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
  String option= request.getParameter("update-option");
  
  if(option.equals("NAME"))
  {
%>
   <form action="update">
   ENTER NEW NAME : <input type="text" name="employeeName">  <br><br>
   <input type="submit">
   </form>
<%} 
  
   else if(option.equals("EMAIL"))
{
%>
   <form action="update">
   ENTER NEW EMAIL : <input type="text" name="email">  <br><br>
   <input type="submit">
   </form>
<%} 
  
   else if(option.equals("PHONENUMBER"))
{
%>
   <form action="update">
   ENTER NEW PHONENUMBER : <input type="text" name="phoneNumber">  <br><br>
   <input type="submit">
   </form>
<%} %>     
 

</body>
</html>