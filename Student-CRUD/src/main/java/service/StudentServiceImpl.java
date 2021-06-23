package service;

import java.util.List;

import dao.StudentDao;
import dao.StudentDaoImpl;
import entity.Student;

public class StudentServiceImpl implements StudentService {
	StudentDao stDao=new StudentDaoImpl();
	@Override
	public String addStudent(Student std) {
		return stDao.addStudent(std);
	}

	@Override
	public List<Student> getAllStudent() {
		return stDao.getAllStudent();
	}
	
	@Override
	public Student getStudent(int id) {
		return stDao.getStudent(id);
	}
	
	@Override
	public String updateStudent(Student std) {
		return stDao.updateStudent(std);
	}

	@Override
	public String deleteStudent(int id) {
		return stDao.deleteStudent(id);
	}

}
