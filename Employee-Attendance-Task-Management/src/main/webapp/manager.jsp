<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Manager Page</h1>
<h2><a href="addDeveloper.jsp">ADD-DEVELOPER</a></h2>
<h2><a href="createTask.jsp">CREATE-TASK</a></h2>
<h2><a href="assignTask.jsp">ASSIGN-TASK</a></h2>
<h2><a href="displayDeveloperTasks">VIEW-ALL-DEVELOPER-WITH-TASK</a></h2> <!-- remaining -->
<h2><a href="deleteDeveloper.jsp">DELETE-DEVELOPER</a></h2>
<h2><a href="logout.jsp">LOGOUT</a></h2>

</body>
</html>

<!-- Logout
take attendance id from form 
use id to fetch Attendance obj
attendance.setLogoutTime(LocalDateTime.now()); 
update attendance obj-->