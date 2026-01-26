package com.bpi.module5.dao;

import java.util.List;

import com.bpi.module5.model.Student;

public interface StudentDAO {

		void addStudent(String name, int age, String email);
		List<Student> showAllStudent();
		
}
