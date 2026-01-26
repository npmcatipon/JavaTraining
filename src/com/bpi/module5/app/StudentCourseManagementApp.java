package com.bpi.module5.app;

import org.slf4j.LoggerFactory;

import com.bpi.module5.dao.impl.CoursesDAOImpl;
import com.bpi.module5.dao.impl.StudentDAOImpl;
import com.bpi.module5.model.Courses;
import com.bpi.module5.model.Student;
import com.bpi.module5.service.CourseService;
import com.bpi.module5.service.StudentService;
import com.bpi.module5.service.impl.CourseServiceImpl;
import com.bpi.module5.service.impl.StudentServiceImpl;

import java.util.Scanner;

import org.slf4j.Logger;

public class StudentCourseManagementApp {
	
	public static final Logger logger = (Logger) LoggerFactory.getLogger(StudentCourseManagementApp.class);
	
	public static void main(String[] args) {
		
		StudentService studentService = new StudentServiceImpl(new StudentDAOImpl());
		CourseService courseService = new CourseServiceImpl(new CoursesDAOImpl());
		 
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("===== STUDENT COURSE MANAGEMENT SYSTEM =====");
			System.out.println("1. Add Student");
			System.out.println("2. Add Course");
			System.out.println("3. Show Student");
			System.out.println("4. Show Course");
			System.out.println("0. Exit");
			System.out.println("Choose an option: ");
						
			int input = scanner.nextInt();
			scanner.nextLine();
			
			switch(input) {
				case 1:
					System.out.print("Enter Name: ");
					String name = scanner.nextLine();
					
					System.out.print("Enter Age: ");
					int age = scanner.nextInt();
					scanner.nextLine();
					
					System.out.print("Enter Email: ");
					String email = scanner.nextLine();
										
					studentService.addStudent(name, age, email);
					System.out.printf("Student Name: %s, Age: %d, Email: %s. Addedd successfully.%n", name, age, email);
					break;
				case 2:
					System.out.println("Enter Student ID: ");
					int studentId = scanner.nextInt();
					scanner.nextLine();
					
					System.out.println("Enter Course Name: ");
					String courseName = scanner.nextLine();
					
					System.out.println("Enter Grade: ");
					int grade = scanner.nextInt();
					scanner.nextLine();
					
					courseService.addCourse(studentId, courseName, grade);
					System.out.printf("Student ID: %d, Course Name: %s, Grade: %d. Added successfully.%n", studentId, courseName, grade);
					break;
				case 3:
					System.out.println("\nID | Name | Age | Email");
					System.out.println("--------------------------------------------");
					for (Student s: studentService.getStudents()) {
						System.out.printf("%d | %s | %d | %s%n",s.getId(),s.getName(),s.getAge(),s.getEmail());
					}
					break;
				case 4:
					System.out.println("\nID | Student ID | Course Name | Grade");
					System.out.println("--------------------------------------------");
					for (Courses c: courseService.getCourse()) {
						System.out.printf("%d | %d | %s | %d%n",c.getId(),c.getStudent_id(),c.getCourse_name(),c.getGrade());
					}
					break;
				case 0:
					scanner.close();
					System.out.println("Goodbye!");
					System.exit(0);
					return;
			}
		}
	}

}
