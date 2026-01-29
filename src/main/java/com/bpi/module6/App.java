package com.bpi.module6;

import com.bpi.module6.model.Courses;
import com.bpi.module6.model.Student;
import com.bpi.module6.util.EntityManagerUtil;

import jakarta.persistence.EntityManager;

public class App
{
    public static void main( String[] args ) {
    	EntityManager em = EntityManagerUtil.createEntityManager();
    	try {
    		run(em);
    	} finally {
			EntityManagerUtil.close(em);
			EntityManagerUtil.shutdown();
		}
    }

	static void run(EntityManager em) {
		em.getTransaction().begin();
		
		Student student = new Student(22,"Jerry Doe", "jerrydoe7@gmail.com");
		em.persist(student);
		
		em.flush();
		em.detach(student);

		System.out.println("is newstudent inside the persistence context." + em.contains(student));
		
		Student managed = em.merge(student);
		managed.setAge(23);
		
		em.flush();
		
		System.out.println("is newstudent inside the persistence context." + em.contains(managed));
		
		em.remove(managed);
		em.flush();
		
		System.out.println("is newstudent inside the persistence context." + em.contains(student));

		em.getTransaction().commit();
	}
}
