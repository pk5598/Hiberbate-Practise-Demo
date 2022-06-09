package com.jpa.advHibernate.Repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import com.jpa.advHibernate.AdvHibernateApplication;
import com.jpa.advHibernate.entity.Course;



@SpringBootTest(classes = AdvHibernateApplication.class)
public class CourseSpringDataRepoTest {
	
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepo courseSpringDataRepo;
	
	@Test
	public void findyId() {
		Optional<Course> course=courseSpringDataRepo.findById(10001L);
	    assertTrue(course.isPresent());
	
	}
	
	@Test
	public void Course_CRUD() {
		
		//create
		Course course=new Course("Devops in 100 steps");
		courseSpringDataRepo.save(course);

		//update
		course.setName("Devops in 100 steps-updated");
		courseSpringDataRepo.save(course);
		
		
		//read
		logger.info("Courses ->{}",courseSpringDataRepo.findAll());
		logger.info("Count ->{}",courseSpringDataRepo.count());
		
		//delete
		courseSpringDataRepo.deleteById(1L);
		logger.info("Count ->{}",courseSpringDataRepo.count());
		

	}
	
	@Test
	public void Course_SortingUsingJPA() {

		//read (sorted)
		Sort sort=Sort.by(Sort.Direction.ASC, "name");
		logger.info("Courses ->{}",courseSpringDataRepo.findAll(sort));
		
		
	
		

	}
	
	@Test
	public void findCourseUsingName(){

		
		
		logger.info("Courses ->{}",courseSpringDataRepo.findByName("Jpa in 50 steps"));
		
		
	
		

	}
	
	
}
