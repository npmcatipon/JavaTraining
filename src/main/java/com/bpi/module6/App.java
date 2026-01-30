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

		Student newStudent2 = new Student(22,"Jane Smith", "janesmith@gmail.com");
		em.persist(newStudent2);

		Student newStudent3 = new Student(23,"Michael Johnson", "michael.johnson@gmail.com");
		em.persist(newStudent3);

		Student newStudent4 = new Student(24,"Emily Davis", "emily.davis@gmail.com");
		em.persist(newStudent4);

		Student newStudent5 = new Student(25,"Christopher Brown", "chris.brown@gmail.com");
		em.persist(newStudent5);
		
		em.getTransaction().commit();
	}
	
	static void persistOneToMany(EntityManager em) {
		em.getTransaction().begin();
		
		Student st1 = em.find(Student.class, 1L);
		Student st2 = em.find(Student.class, 2L);
		Student st3 = em.find(Student.class, 3L);
		Student st4 = em.find(Student.class, 4L);
		Student st5 = em.find(Student.class, 5L);

		
		Courses nc1 = new Courses("Mathematics",88,st1); em.persist(nc1);
		Courses nc2 = new Courses("Science",90,st1); em.persist(nc2);
		Courses nc3 = new Courses("Computer Basics",89,st2); em.persist(nc3);
		Courses nc4 = new Courses("English Literature",92,st3); em.persist(nc4);
		Courses nc5 = new Courses("History",85,st4); em.persist(nc5);
		Courses nc6 = new Courses("Physics",91,st5); em.persist(nc6);
		Courses nc7 = new Courses("Chemistry",87,st1); em.persist(nc7);
		Courses nc8 = new Courses("Biology",84,st2); em.persist(nc8);
		Courses nc9 = new Courses("Algebra",93,st3); em.persist(nc9);
		Courses nc10 = new Courses("World Geography",86,st4); em.persist(nc10);
		
		em.getTransaction().commit();
	}
}
