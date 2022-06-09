package com.jpa.advHibernate;

import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.advHibernate.Repository.CourseRepo;
import com.jpa.advHibernate.Repository.EmployeeRepo;
import com.jpa.advHibernate.Repository.StudentRepo;
import com.jpa.advHibernate.entity.Course;
import com.jpa.advHibernate.entity.Employee;
import com.jpa.advHibernate.entity.FullTimeEmployee;
import com.jpa.advHibernate.entity.PartTimeEmployee;
import com.jpa.advHibernate.entity.Review;

import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class AdvHibernateApplication implements CommandLineRunner{
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AdvHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//Course course=courseRepo.findById(10001L);
		//logger.info("Course 10001 ->{}",course);
		
		//repo.deleteById(10001L);
		//courseRepo.save(new Course("Microservices in 100 steps"));
		//repo.update(1L,"Microservices in 10 steps");
		//studentRepo.saveStudentwithPassport();
		
		//courseRepo.addReviewsForCourse();
		
		//List<Review> reviews=new ArrayList<Review>();
		
		//reviews.add(new Review("3","average stuff"));
		
		//reviews.add(new Review("4","good stuff"));
		//courseRepo.addReviewsForCourse(10003L,reviews);
		//studentRepo.insertStudentAndCourse();
		
		//employeeRepo.insert(new FullTimeEmployee("Prasanna", new BigDecimal("1000")));
		//employeeRepo.insert(new PartTimeEmployee("Kane", new BigDecimal("50")));
		//logger.info("List of employees ->{}",employeeRepo.retrieveAllEmployee());
	}

}
