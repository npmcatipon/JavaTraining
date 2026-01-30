package com.bpi.module6;

import java.util.List;

import com.bpi.module6.model.Student;
import com.bpi.module6.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class App
{
    public static void main( String[] args ) {
    	EntityManager em = EntityManagerUtil.createEntityManager();
    	try {
    		printAllStudentNames(em);
    		
    		Long studentId = 2L;
    		Long coursesByStudentId = countCoursesByStudentId(em, studentId);
    		System.out.println("Count of Courses per Student ID " + studentId.intValue() + " is " + coursesByStudentId);
    		
    		int targetAge = 22;
    		int studentAgeGreaterThan = countStudentAgeGreaterThan(em, targetAge);
    		System.out.println("Count of Students Age is Greater Than " + targetAge + " is " + studentAgeGreaterThan);
    		
    	} finally {
			EntityManagerUtil.close(em);
			EntityManagerUtil.shutdown();
		}
    }

	static int countStudentAgeGreaterThan(EntityManager em, int i) {
		em.getTransaction().begin();
		String jpql = """
				SELECT COUNT(s) FROM Student s WHERE s.age > :age
				""";
		Long result = em.createQuery(jpql,Long.class).setParameter("age", i).getSingleResult();
		em.getTransaction().commit();
		return result.intValue();
	}

	static Long countCoursesByStudentId(EntityManager em, long id) {
		em.getTransaction().begin();
		
		String jpql = "SELECT COUNT(s) FROM Student s JOIN s.courses WHERE s.id = :student_id";
		Long query = em.createQuery(jpql, Long.class).setParameter("student_id", id).setParameter("student_id",id).getSingleResult();
		em.getTransaction().commit();
		return query;
	}

	static void printAllStudentNames(EntityManager em) {
		em.getTransaction().begin();
		
		String jpql = "SELECT s FROM Student s";
		TypedQuery<Student> query = em.createQuery(jpql, Student.class);
		List<Student> students = query.getResultList();
		
		students.forEach(student -> System.out.printf("Student ID %d, Student Name: %s%n", student.getId(),student.getName()));
		
		em.getTransaction().commit();
	}
}
