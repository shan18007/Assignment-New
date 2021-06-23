<!DOCTYPE html>
<%@page import="entity.Student"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update student</title>
</head>
<body>

<%
Student std= (Student)session.getAttribute("student");
%>
	<form action="Update" method="post">
		<label>STUDENT NO</label> <input type="number" name="sno" value="<%=std.getS_no() %>" readonly> <br>
		<br> <label>STUDENT NAME</label> <input type="text"  name="sname" value="<%=std.getSname() %>"><br>
		<br> <label>STUDENT DOB</label> <input type="date"  name="sdob" value="<%=std.getDob() %>"><br>
		<br> <label>STUDENT DOJ</label> <input type="date"  name="sdoj" value="<%=std.getDoj() %>"><br>
		<br> <input type="submit">
	</form>
	<br>
	<a href="index.html">Home</a>
</body>
</html>