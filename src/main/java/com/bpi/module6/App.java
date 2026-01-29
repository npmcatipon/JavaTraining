package com.bpi.module6;

import com.bpi.M6.util.EntityManagerUtil;
import com.bpi.module6.model.Courses;
import com.bpi.module6.model.Student;

import jakarta.persistence.EntityManager;

public class App
{
    public static void main( String[] args ) {
    	EntityManager em = EntityManagerUtil.createEntityManager();
    	try {
    		runM6Activity2(em);
    		persistOneToMany(em);
    	} finally {
			EntityManagerUtil.close(em);
			EntityManagerUtil.shutdown();
		}
    }

	static void runM6Activity2(EntityManager em) {
		em.getTransaction().begin();
		
		Student newStudent1 = new Student(21,"John Doe", "johndoe@gmail.com");
		em.persist(newStudent1);
		
		Student newStudent2 = new Student(21,"Jane Doe", "janedoe@gmail.com");
		em.persist(newStudent2);
		
		em.getTransaction().commit();
	}
	
	static void persistOneToMany(EntityManager em) {
		em.getTransaction().begin();
		
		Student st1 = em.find(Student.class, 1L);
		Student st2 = em.find(Student.class, 2L);
		
		Courses nc1 = new Courses("Mathematics",88,st1);
		Courses nc2 = new Courses("Science",90,st1);
		Courses nc3 = new Courses("Computer Basics",89,st2);
		
		em.persist(nc1);
		em.persist(nc2);
		em.persist(nc3);
		
		em.getTransaction().commit();
	}
}
