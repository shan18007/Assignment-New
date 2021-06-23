package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Student;
import service.StudentService;
import service.StudentServiceImpl;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw=new PrintWriter(response.getWriter());
		
		int id= Integer.parseInt(request.getParameter("sid"));
		
		StudentService stdService = new StudentServiceImpl();
		Student std = stdService.getStudent(id);
		
		HttpSession session= request.getSession();
		session.setAttribute("student", std);
		response.sendRedirect("update-student.jsp");		
  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw=new PrintWriter(response.getWriter());
		
		Student std = new Student();
		std.setS_no(Integer.parseInt(request.getParameter("sno")));
		std.setSname(request.getParameter("sname"));
		std.setDob(request.getParameter("sdob"));
		std.setDoj(request.getParameter("sdoj"));
		
		StudentService stdService = new StudentServiceImpl();
		String res = stdService.updateStudent(std);
		HttpSession session= request.getSession();
		if(res.equals("success")) {
			session.setAttribute("msg", "Student Updated Successfully");
			response.sendRedirect("ReadServlet");
			
		}else {
			session.setAttribute("msg", "Something went wrong..!");			
		}
	
	}

}
