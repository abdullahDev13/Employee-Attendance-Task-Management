<%@page import="com.eatm.entity.Task"%>
<%@page import="java.util.List"%>
<%@page import="com.eatm.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%  Employee dbemployee= (Employee)request.getAttribute("dbemployee");
   
    List<Task> dbtaskList= dbemployee.getTaskList();
    
    for(Task t : dbtaskList)
    {
%>

<%= t.getTaskId() %>
<%= t.getTaskName() %>
<%= t.getDuration() %>
<%= t.getStatus() %>
<br>
<%} %>




</body>
</html>