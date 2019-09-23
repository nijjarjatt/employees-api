package com.taleroid.employeesapi.service;

import java.util.List;

import com.taleroid.employeesapi.dao.EmployeeDao;
import com.taleroid.employeesapi.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmplpyeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmplpyeeServiceImpl(EmployeeDao thEmployeeDao) {
		employeeDao = thEmployeeDao; 
	}
 
	@Override
	@Transactional
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		employeeDao.saveEmployee(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
		
	}

}
