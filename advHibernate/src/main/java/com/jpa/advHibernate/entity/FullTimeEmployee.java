package com.jpa.advHibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {
	
	BigDecimal salary;
	
	public   FullTimeEmployee() {
		
	}
	
	public FullTimeEmployee(String name,BigDecimal salary) {
		super(name);
		this.salary=salary;
		
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "FullTimeEmployee [salary=" + salary + "]";
	}
	
	

}
