package com.jpa.advHibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Passport {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "number",nullable = false)
	private  String number;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
	private Student student;
	
	
	public Passport() {
		
	}
	
	public Passport(String number) {
		this.number=number;
	}
	
	public String  getNumber() {
		return this.number;
		
	}
	
	public void setNumber(String number) {
		this.number=number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		id = id;
	}
	

	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + number + "]";
	}
}
