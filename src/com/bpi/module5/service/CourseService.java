package com.bpi.module5.service;

import java.util.List;

import com.bpi.module5.model.Courses;

public interface CourseService {
	
	void addCourse(int studentId, String courseName, int grade);
	List<Courses> getCourse();
	
}
