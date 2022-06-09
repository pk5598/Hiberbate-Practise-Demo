package com.jpa.advHibernate.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.advHibernate.entity.Course;
import com.jpa.advHibernate.entity.Review;

@Repository
@Transactional
public class CourseRepo {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class,id);
		
	}
	
	public Course save(Course course) {
		if (course.getId()==null) {
			//insert
			em.persist(course);
		}
		else {
			//update 
			em.merge(course);
		}
		
		return course;
		
	}
	
	/*public void addReviewsForCourse() {
		Course course=this.findById(10003L);
		
		logger.info("course.getReviews() -> {}",course.getReviews());
		
		Review review1=new Review("5","Great hands on stuff");
		
		Review review2=new Review("4","cool stuff");
		
		course.addReview(review2);
		review1.setCourse(course);
		
		
		course.addReview(review1);
		review2.setCourse(course);
		
		em.persist(review1);
		em.persist(review2);
	
	}*/
	
	public void addReviewsForCourse(Long courseId,List<Review> reviews) {
		Course course=this.findById(courseId);
		
		logger.info("course.getReviews() -> {}",course.getReviews());
		
		for (Review review : reviews) {

			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
			
		}

	}
	
	public void deleteById(Long Id) {
		
		em.remove(findById(Id));
	}
	
	

}
