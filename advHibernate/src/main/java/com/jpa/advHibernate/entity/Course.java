package com.jpa.advHibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name",nullable = false)
	private  String name;
	
	@OneToMany(mappedBy = "course")
	private List<Review> reviews=new ArrayList<Review>();
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students=new ArrayList<Student>();
	
	
	public Course() {
		
	}
	
	public Course(String name) {
		this.name=name;
	}
	
	public String  getName() {
		return this.name;
		
	}
	
	public void setName(String name) {
		this.name=name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void remove(Review review) {
		this.reviews.remove(review);
	}

	
	
	
	
	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	

}
