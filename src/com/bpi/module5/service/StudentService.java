package com.bpi.module5.service;

import java.util.List;

import com.bpi.module5.model.Student;

public interface StudentService {

		void addStudent(String name, int age, String email);
		List<Student> getStudents();
}
