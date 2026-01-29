package com.bpi.module6.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "age",
			columnDefinition = "INT")
	private int age;
	
	@Column(name = "name",
			nullable = false,
			length = 50,
			columnDefinition = "VARCHAR(50)")
	private String name;
	
	@Column(name = "emai",
			unique = true,
			length = 100,
			columnDefinition = "VARCHAR(100)")
	private String email;
	
	@OneToMany(mappedBy = "student")
	private List<Courses> courses;

	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	public Student(int age, String name, String email) {
		super();
		this.age = age;
		this.name = name;
		this.email = email;
	}
	public Student() {}
	
}
