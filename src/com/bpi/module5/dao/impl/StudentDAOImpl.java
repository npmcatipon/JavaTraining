package com.bpi.module5.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.bpi.module5.dao.StudentDAO;
import com.bpi.module5.model.Student;
import com.bpi.module5.util.DBUtil;

public class StudentDAOImpl implements StudentDAO {
	
	private static final String ADD_STUDENT =
			"INSERT INTO students(name,age,email) VALUES (?,?,?)";
	private static final String SHOW_STUDENT = 
			"SELECT id,name,age,email FROM students;";

	@Override
	public void addStudent(String name, int age, String email) {
		try (Connection conn = DBUtil.getConnection(); 
				PreparedStatement ps = conn.prepareStatement(ADD_STUDENT)) {
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, email);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("Failed to add student.", e);
		}
	}

	@Override
	public List<Student> showAllStudent() {
		List<Student> student = new ArrayList<>();
		
		try (Connection conn = DBUtil.getConnection();
				PreparedStatement ps = conn.prepareStatement(SHOW_STUDENT);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				student.add(new Student(
						rs.getInt("id"), 
						rs.getString("name"),
						rs.getInt("age"),
						rs.getString("email")
				));
			}
						
		} catch (SQLException e) {
			throw new RuntimeException("Failed to list all students.", e);
		}
		return student;
	}
}
