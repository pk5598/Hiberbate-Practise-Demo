package com.jpa.advHibernate.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.advHibernate.AdvHibernateApplication;
import com.jpa.advHibernate.entity.Course;
import com.jpa.advHibernate.entity.Student;

//@SpringBootTest(classes = AdvHibernateApplication.class)
public class JpqlTest {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	void Jpql_basic() {
		List resList=em.createQuery("Select c from Course c").getResultList();
		logger.info("Select c from Course c -> {}",resList);
	
	}
	
	@Test
	void jpql_typed() {
		
		TypedQuery<Course> query=em.createQuery("Select c from Course c",Course.class);
		List<Course> resList=query.getResultList();
		logger.info("Select c from Course c -> {}",resList);
	
	}
	
	@Test
	void jpql_where() {
		
		TypedQuery<Course> query=em.createQuery("Select c from Course c where name like '%50 steps'",Course.class);
		List<Course> resList=query.getResultList();
		logger.info("Select c from Course c where name like '%50 Steps'-> {}",resList);
	
	}
	
	@Test
	public void jpql_coursesWithoutStudents() {
		
		TypedQuery<Course> query=em.createQuery("Select c from Course c where c.students is empty",Course.class);
		List<Course> resList=query.getResultList();
		logger.info("Select c from Course c where c.students is empty -> {}",resList);
	
	}
	
	@Test
	public void jpql_coursesWithAtLeastTwoStudents() {
		
		TypedQuery<Course> query=em.createQuery("Select c from Course c where size(c.students)>=2",Course.class);
		List<Course> resList=query.getResultList();
		logger.info("Select courses with atleast 2 student -> {}",resList);
	
	}
	
	@Test
	public void jpql_orderByStudents() {
		
		TypedQuery<Course> query=em.createQuery("Select c from Course c order by size(c.students)",Course.class);
		List<Course> resList=query.getResultList();
		logger.info("Select courses order by students-> {}",resList);
	
	}
	
	@Test
	public void jpql_Student_passport_withPattern() {
		
		TypedQuery<Student> query=em.createQuery("Select s from Student s where s.passport.number like '%1234%' ",Student.class);
		List<Student> resList=query.getResultList();
		logger.info("Select student with passport number pattern 1234-> {}",resList);
	
	}
	
	/*
	 * @Test public void jpql_courseJoinStudent() {
	 * 
	 * Query query=(Query)
	 * em.createQuery("Select c,s from Course c  JOIN c.students s"); List<Object[]>
	 * resList=((javax.persistence.Query) query).getResultList();
	 * logger.info("course join student-> {}",resList.size()); for(Object[]
	 * res:resList) { logger.info("course-> {}",res[0]);
	 * logger.info("student-> {}",res[1]);
	 * 
	 * }
	 * 
	 * }
	 */
	
	
	
	
}
