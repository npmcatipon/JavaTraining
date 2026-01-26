package com.bpi.module5.service.impl;

import java.util.List;

import com.bpi.module5.dao.StudentDAO;
import com.bpi.module5.model.Student;
import com.bpi.module5.service.StudentService;

public class StudentServiceImpl implements StudentService {
	
	private final StudentDAO studentDAO;

	public StudentServiceImpl(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(String name, int age, String email) {
		studentDAO.addStudent(name, age, email);
	}

	@Override
	public List<Student> getStudents() {
		return studentDAO.showAllStudent();
	}

}
