package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import entity.Student;
import service.StudentService;
import service.StudentServiceImpl;

@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Student std=new Student();
		
		PrintWriter pw=new PrintWriter(response.getWriter());
		std.setS_no(Integer.parseInt(request.getParameter("sno")));
		std.setSname(request.getParameter("sname"));
		std.setDob(request.getParameter("sdob"));
		std.setDoj(request.getParameter("sdoj"));;
		StudentService stdService = new StudentServiceImpl();
		String res = stdService.addStudent(std);
		HttpSession session=request.getSession();
		if(res.equals("success")) {
			session.setAttribute("msg", "Student Added Successfully");
			response.sendRedirect("ReadServlet");
			
		}else if(res.equals("fail")) {
			session.setAttribute("msg", "Something went wrong..!");
			response.sendRedirect("ReadServlet");
		}
		else {
			response.sendRedirect("ReadServlet");
		}
		
	}

}
