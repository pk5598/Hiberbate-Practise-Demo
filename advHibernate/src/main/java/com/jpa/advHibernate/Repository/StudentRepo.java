package com.jpa.advHibernate.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.advHibernate.entity.Course;
import com.jpa.advHibernate.entity.Passport;
import com.jpa.advHibernate.entity.Student;

@Repository
@Transactional
public class StudentRepo {
	
	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class,id);
		
	}
	
	public Student save(Student student) {
		if (student.getId()==null) {
			//insert
			em.persist(student);
		}
		else {
			//update 
			em.merge(student);
		}
		
		return student;
		
	}
	
	
	public void saveStudentwithPassport() {
		Passport passport=new Passport("Z12345");
		em.persist(passport);
		
		Student student=new Student("Mike"); 
		student.setPassport(passport);
		em.persist(student);
		
	}
	
	public void insertStudentAndCourse() {
		Student student=new Student("Zuke");
		Course course=new Course("Python in 10 steps");
		em.persist(course);
		em.persist(student);
		student.addCourse(course);
		course.addStudents(student);
		
		//owning side
		em.persist(student);
		
	}
	
	
	
	public void deleteById(Long Id) {
		
		em.remove(findById(Id));
	}
	
	

}
