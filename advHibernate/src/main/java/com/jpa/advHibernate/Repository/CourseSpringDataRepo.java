package com.jpa.advHibernate.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.advHibernate.entity.Course;

public interface CourseSpringDataRepo extends JpaRepository<Course, Long>{
		
	
	List<Course> findByName(String name);
	
}
