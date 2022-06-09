package com.jpa.advHibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	
    private String rating;
    
	private  String description;
	
	@ManyToOne
	private Course course;
	
	public Review() {
		
	}
	
	public Review(String rating,String description) {
		this.description=description;
		this.rating=rating;
		
	}
	
	public String  getdescription() {
		return this.description;
		
	}
	
	public void setdescription(String description) {
		this.description=description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
    
	
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating + ", description=" + description + "]";
	}

	
}
