package com.taleroid.employeesapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import com.taleroid.employeesapi.entity.Employee;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoHibernateImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Employee> employeeQuery = session.createQuery("from Employee", Employee.class);
		
		List<Employee> employees = employeeQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		
		Employee currentEmployee = session.get(Employee.class, theId);
		
		return currentEmployee;
		
		
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void deleteEmployee(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		Query theQuery = session.createQuery("delete from Employee e where e.id=:id");
		
		theQuery.setParameter("id", id);
		
		theQuery.executeUpdate();
	}

}
