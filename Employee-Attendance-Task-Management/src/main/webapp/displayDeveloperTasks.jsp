<%@page import="com.eatm.entity.Task"%>
<%@page import="com.eatm.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Developers With Assigned Tasks</h2>

<table>

<tr>
    <th>Developer ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Password</th>
    <th>PhoneNumber</th>
    <th>Role</th>
    <th>Salary</th>
    <th>TaskId</th>
    <th>TaskName</th>
    <th>Duration</th>
     <th>Status</th>
</tr>

<%
List<Employee> developers = (List<Employee>)request.getAttribute("developers");

for(Employee e : developers){
%>

<tr>

<td><%= e.getEmployeeId() %></td>

<td><%= e.getEmployeeName() %></td>

<td><%= e.getEmail() %></td>

<td><%= e.getPassword() %></td>

<td><%= e.getPhoneNumber() %></td>

<td><%= e.getRole() %></td>

<td><%= e.getSalary() %></td>

<td>

<%
List<Task> taskList = e.getTaskList();

if(taskList != null && !taskList.isEmpty()){

    for(Task t : taskList){
%>

<p>

<b>Task ID:</b> <%= t.getTaskId() %>



<b>Name:</b> <%= t.getTaskName() %>



<b>Duration:</b> <%= t.getDuration() %>



<b>Status:</b> <%= t.getStatus() %>

</p>



<%
    }

}else{
%>

No Tasks Assigned

<%
}
%>

</td>

</tr>

<%
}
%>

</table> 

</body>
</html>