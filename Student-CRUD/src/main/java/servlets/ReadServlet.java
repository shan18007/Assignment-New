package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Student;
import service.StudentService;
import service.StudentServiceImpl;

/**
 * Servlet implementation class ReadServlet
 */
@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in Read");
		StudentService stdService = new StudentServiceImpl();
		List<Student> list = stdService.getAllStudent();
		System.out.println("Size2: "+list.size());
		HttpSession session= request.getSession();
		session.setAttribute("studentList", list);
		response.sendRedirect("view-student.jsp");
	}

}
