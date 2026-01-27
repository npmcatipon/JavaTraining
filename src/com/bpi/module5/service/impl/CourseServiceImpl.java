package com.bpi.module5.service.impl;

import java.util.List;

import com.bpi.module5.dao.CoursesDAO;
import com.bpi.module5.model.Courses;
import com.bpi.module5.service.CourseService;

public class CourseServiceImpl implements CourseService {
	
	private final CoursesDAO courseDAO;
	
	public CourseServiceImpl(CoursesDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	@Override
	public void addCourse(int studentId, String courseName, int grade) {
		courseDAO.addCourse(studentId, courseName, grade);
	}

	@Override
	public List<Courses> getCourse() {
		return courseDAO.showAllCourses();
	}
	
	@Override
	public boolean isValid(int studentId) {
		return courseDAO.checkStudentId(studentId);
	}
}
