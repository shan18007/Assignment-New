package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Student;

public class StudentDaoImpl implements StudentDao {
	public DB db;

	public StudentDaoImpl() {
		this.db = new DB();
	}

	@Override
	public String addStudent(Student std) {
		String msg = "fail";
		Connection con = db.getDbConnection();

		try {
			PreparedStatement pst = con.prepareStatement("insert into student values(?,?,?,?)");
			pst.setInt(1, std.getS_no());
			pst.setString(2, std.getSname());
			pst.setString(3, std.getDob());
			pst.setString(4, std.getDoj());

			int res = pst.executeUpdate();
			if (res > 0) {
				msg = "success";
			} else {
				msg = "fail";
			}
		} catch (Exception e) {
			return e.toString();
		}
		return msg;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list = new ArrayList<Student>();
		Connection con = db.getDbConnection();
		Student std;
		try {
			PreparedStatement pst = con.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				 std = new Student();
				std.setS_no(rs.getInt("STUDENT_NO"));
				std.setSname(rs.getString("STUDENT_NAME"));
				std.setDob(rs.getString("STUDENT_DOB"));
				std.setDoj(rs.getString("STUDENT_DOJ"));
				list.add(std);
			}
			System.out.println("method size: "+list.size());
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	@Override
	public Student getStudent(int id) {
		Student std = new Student();
		Connection con = db.getDbConnection();
		try {
			PreparedStatement pst = con.prepareStatement("select * from student where STUDENT_NO=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				std.setS_no(rs.getInt("STUDENT_NO"));
				std.setSname(rs.getString("STUDENT_NAME"));
				std.setDob(rs.getString("STUDENT_DOB"));
				std.setDoj(rs.getString("STUDENT_DOJ"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return std;
	}

	@Override
	public String updateStudent(Student std1) {
		String msg = null;
		Connection con = db.getDbConnection();
		try {
			PreparedStatement pst = con.prepareStatement(
					"update student set STUDENT_NAME=?,STUDENT_DOB=?,STUDENT_DOJ=? where STUDENT_NO=?");
			pst.setString(1, std1.getSname());
			pst.setString(2, std1.getDob());
			System.out.println(std1.getDoj());
			pst.setString(3, std1.getDoj());
			pst.setInt(4, std1.getS_no());
			int res = pst.executeUpdate();
			if (res > 0) {
				msg = "success";
			} else {
				msg = "fail";
			}
		} catch (Exception e) {
			System.out.println(e);
			return e.toString();
		}
		return msg;
	}

	@Override
	public String deleteStudent(int id) {
		String msg = "fail";
		Connection con = db.getDbConnection();
		try {
			PreparedStatement pst = con.prepareStatement("delete from student where STUDENT_NO=?");
			pst.setInt(1, id);
			int res = pst.executeUpdate();
			System.out.println(res);
			if (res > 0) {
				msg = "success";
			} else {
				msg = "fail";
			}
		} catch (Exception e) {
			return e.toString();
		}
		return msg;
	}

}
