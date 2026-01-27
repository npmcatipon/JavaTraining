package com.bpi.module5.dao;

import java.util.List;

import com.bpi.module5.model.Courses;

public interface CoursesDAO {
	
	void addCourse(int studentId,String courseName,int grade);
	List<Courses> showAllCourses();
	boolean checkStudentId(int studentId);
	
}
