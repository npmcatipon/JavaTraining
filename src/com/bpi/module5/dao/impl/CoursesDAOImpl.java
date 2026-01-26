package com.bpi.module5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bpi.module5.dao.CoursesDAO;
import com.bpi.module5.model.Courses;
import com.bpi.module5.util.DBUtil;

public class CoursesDAOImpl implements CoursesDAO {

	private static final String ADD_COURSE =
			"INSERT INTO courses(student_id,course_name,grade) VALUES (?,?,?)";
	private static final String SHOW_COURSE =
			"SELECT id,student_id,course_name,grade FROM courses";
	
	@Override
	public void addCourse(int studentId, String courseName, int grade) {
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(ADD_COURSE)) {
			ps.setInt(1,studentId);
			ps.setString(2, courseName);
			ps.setInt(3, grade);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Failed to add a course.", e);
		}
	}

	@Override
	public List<Courses> showAllCourses() {
		List<Courses> course = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(SHOW_COURSE);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				course.add(new Courses(
						rs.getInt("id"),
						rs.getInt("student_id"),
						rs.getString("course_name"),
						rs.getInt("grade")
				));
			}
			
		} catch (SQLException e) {
			throw new RuntimeException("Failed to show all courses.", e);
		}
		
		return course;
	}

}
