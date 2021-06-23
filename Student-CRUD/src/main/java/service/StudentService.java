package service;

import java.util.List;

import entity.Student;

public interface StudentService {
	public String addStudent(Student std);

	public List<Student> getAllStudent();
	public Student getStudent(int id);
	public String updateStudent(Student std);

	public String deleteStudent(int id);
}
