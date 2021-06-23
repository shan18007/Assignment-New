package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.StudentService;
import service.StudentServiceImpl;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = new PrintWriter(response.getWriter());

		int id = Integer.parseInt(request.getParameter("sid"));
		StudentService stdService = new StudentServiceImpl();
		String res = stdService.deleteStudent(id);
		HttpSession session= request.getSession();
		if (res.equals("success")) {
			session.setAttribute("msg", "Student Deleted Successfully") ;
			response.sendRedirect("ReadServlet");
		} else {
			session.setAttribute("msg", "Something went wrong..!");
			response.sendRedirect("ReadServlet");
		}

	}
}
