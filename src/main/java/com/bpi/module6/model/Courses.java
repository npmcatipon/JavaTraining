package com.bpi.module6.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (name = "course_name", 
			 nullable = false, 
			 columnDefinition = "VARCHAR(50)", 
			 length = 50)
	private String courseName;
	
	@Column(name = "grade",
			columnDefinition = "INT")
	private int grade;
	
	@ManyToOne
	@JoinColumn(name = "student_id",
			    nullable = false)
	private Student student;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Courses(String courseName, int grade) {
		super();
		this.courseName = courseName;
		this.grade = grade;
	}
	
	public Courses(String courseName, int grade, Student student) {
		super();
		this.student = student;
		this.courseName = courseName;
		this.grade = grade;
	}
	
	public Courses() {}
}
