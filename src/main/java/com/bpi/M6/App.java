package com.bpi.M6;

import com.bpi.M6.model.Student;
import com.bpi.M6.util.EntityManagerUtil;
import jakarta.persistence.EntityManager;

public class App
{
    public static void main( String[] args ) {
    	EntityManager em = EntityManagerUtil.createEntityManager();
    	try {
    		runM6Activity2(em);
    	} finally {
			EntityManagerUtil.close(em);		}
    }

	static void runM6Activity2(EntityManager em) {
		em.getTransaction().begin();
		
		Student newStudent = new Student();
		newStudent.setName("Testing name");
		newStudent.setAge(22);
		newStudent.setEmail("testing@gmail.com");
		
		em.persist(newStudent);
		em.getTransaction().commit();
	}    	
}
