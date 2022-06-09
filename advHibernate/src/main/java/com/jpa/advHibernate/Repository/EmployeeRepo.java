package com.jpa.advHibernate.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpa.advHibernate.entity.Employee;

@Repository
@Transactional
public class EmployeeRepo {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	//insert employee
	public void insert(Employee employee) {
		em.persist(employee);

	}
	
	//retrieve all employee
	public List<Employee> retrieveAllEmployee() {
		return em.createQuery("select e from Employee e",
				Employee.class).getResultList();
	}
	
	

}
