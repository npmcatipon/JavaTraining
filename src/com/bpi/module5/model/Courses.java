package com.bpi.module5.model;

public class Courses {

	private int id;
	private int student_id;
	private String course_name;
	private int grade;
	public Courses(int id, int student_id, String course_name, int grade) {
		super();
		this.id = id;
		this.student_id = student_id;
		this.course_name = course_name;
		this.grade = grade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
