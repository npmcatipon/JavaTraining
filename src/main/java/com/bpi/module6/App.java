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
    		
    		Long coursesByStudentId = countCoursesByStudentId(em, 14L);
    		System.out.println("Count of Courses per Student ID 14L is " + coursesByStudentId);
    		
    		int studentAgeGreaterThan = countStudentAgeGreaterThan(em, 18);
    		System.out.println("Count of Students Age is Greater Than 22 : " + studentAgeGreaterThan);
    		
    	} finally {
			EntityManagerUtil.close(em);
			EntityManagerUtil.shutdown();
		}
    }

	static void test(EntityManager em, long l) {
		em.getTransaction().begin();
		String j = """
				
				""";
		em.getTransaction().commit();
	}

	static int countStudentAgeGreaterThan(EntityManager em, int i) {
		em.getTransaction().begin();
		String jpql = """
				SELECT COUNT(s) FROM Student s WHERE s.age > :age
				""";
		Long result = em.createQuery(jpql,Long.class).setParameter("age", i).getSingleResult();
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
		
		students.forEach(student -> System.out.println(student.getName()));
		
		em.getTransaction().commit();
	}
}
