package com.eatm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eatm.entity.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	EntityManager entityManager;
	@Autowired
	EntityTransaction entityTransaction;
	
	public Employee saveEmployee(Employee employee) {
		entityManager.persist(employee);
		entityTransaction.begin();
		entityTransaction.commit();
		return employee;
	}
	public Employee updateEmployee(Employee employee) {
		entityManager.merge(employee);
		entityTransaction.begin();
		entityTransaction.commit();
		return employee;
	}
	public Employee deleteEmployee(Employee employee) {
		entityManager.remove(employee);
		entityTransaction.begin();
		entityTransaction.commit();
		return employee;
	}
	public Employee findEmployeeById(int employeeId) {
		return entityManager.find(Employee.class, employeeId);
	}
	
	public List<Employee> findAllEmployee()
	{
		Query query=entityManager.createQuery("Select e from Employee e");
		return query.getResultList();
	}
	
	public Employee findEmployeebyEmailAndPassword(String email, String password)
	{
		Query query= entityManager.createQuery("select employee from Employee employee where employee.email= ?1 and employee.password= ?2");
		
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<Employee> employeeList= query.getResultList();
		
		if(employeeList.size()>0)
		{
			return employeeList.get(0);
		}
		return null;
	}

}
