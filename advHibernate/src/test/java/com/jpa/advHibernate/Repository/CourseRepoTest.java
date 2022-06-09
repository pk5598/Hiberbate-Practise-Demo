package com.jpa.advHibernate.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.jpa.advHibernate.AdvHibernateApplication;
import com.jpa.advHibernate.entity.Course;

//@SpringBootTest(classes = AdvHibernateApplication.class)
public class CourseRepoTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepo courseRepo;
	
	@Test
	void findById_Test() {
		Course course=courseRepo.findById(10001L);
		//logger.info("Test is running");
		assertEquals("Jpa in 50 steps",course.getName());
		
	}
	
	@Test
	@DirtiesContext
	void DeleteById_Test() {
		courseRepo.deleteById(10002L);
		//logger.info("Test is running");
		
		assertNull(courseRepo.findById(10002L));
		
	}
	@Test
	@DirtiesContext
	void save_Test() {
		Course course=
		courseRepo.findById(1L);
		//test
		assertEquals("Microservices in 100 steps",course.getName());
		
		//update
		course.setName("Microservices in 100 steps-updated");
		
		courseRepo.save(course);
		
		Course course1=courseRepo.findById(1L);
		assertEquals("Microservices in 100 steps-updated",course1.getName());
		
		
	}
	
	
}
