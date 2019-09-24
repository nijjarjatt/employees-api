package com.taleroid.employeesapi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import com.taleroid.employeesapi.entity.Employee;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> employeeQuery = entityManager.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = employeeQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Employee currentEmployee = entityManager.find(Employee.class, theId);
		
		return currentEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		Employee thEmployee = entityManager.merge(theEmployee);
		
		theEmployee.setId(thEmployee.getId());
		
	}

	@Override
	public void deleteEmployee(int id) {
		
		Query theQuery = entityManager.createQuery("delete from Employee e where e.id=:id");
		
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
	}

}
