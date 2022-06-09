package com.jpa.advHibernate.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.advHibernate.AdvHibernateApplication;
import com.jpa.advHibernate.entity.Course;
import com.jpa.advHibernate.entity.Passport;
import com.jpa.advHibernate.entity.Student;

//@SpringBootTest(classes = AdvHibernateApplication.class)
public class StudentRpositoryTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Autowired
	StudentRepo studentRepo;
	
	@Test
	@Transactional
	void retrieveStudentPassport_Details() {
		Student student=em.find(Student.class, 20001L);
		
		logger.info("student ->{}",student);
		logger.info("passport ->{}",student.getPassport());
		
	}
	
	@Test
	@Transactional
	void retrievePassportAndAssociatedStudent_Details() {
		Passport passport=em.find(Passport.class, 40001L);
		
		logger.info("Passport ->{}",passport);
		logger.info("student ->{}",passport.getStudent());
		
	}
	
	@Test
	@Transactional
	public void retriveStudentAndCourses() {
		Student student=em.find(Student.class, 20001L);
		logger.info("student -> {}",student);
		logger.info("student -> {}",student.getCourses());
		
		
	}
	
	
}
