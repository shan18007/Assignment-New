
<%@page import="service.StudentServiceImpl"%>
<%@page import="service.StudentService"%>
<%@page import="entity.Student"%>
<%@page import="java.util.List"%>
<%
List<Student> list = (List<Student>) session.getAttribute("studentList");
Student student;
  
%>

<h1>Student Data</h1>
<br>
<table border="2px">
	<thead>
		<tr>
			<th>Student No.</th>
			<th>Student Name</th>
			<th>Student DOB</th>
			<th>Student DOJ</th>
			<th>Action</th>
		</tr>
	</thead>
	<%
	if (list.size() > 0) {

		for (int i = 0; i < list.size(); i++) {
			student = list.get(i);
	%>
	<tr>
		<td><%=student.getS_no()%></td>
		<td><%=student.getSname()%></td>
		<td><%=student.getDob()%></td>
		<td><%=student.getDoj()%></td>
		<td><a href="Update?sid=<%=student.getS_no()%>">Update</a> <a
			href="Delete?sid=<%=student.getS_no()%> ">Delete</a></td>
	</tr>
	<%
		}
	}

	else {
	%>
	<tr>
		<td colspan="5"><h1>No Data Found...!</h1></td>
	</tr>
	<%
	}
	%>

</table>
<br>
<a href="index.html">Home</a>