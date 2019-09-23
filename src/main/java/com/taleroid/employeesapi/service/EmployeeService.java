package com.taleroid.employeesapi.service;

import java.util.List;

import com.taleroid.employeesapi.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void saveEmployee(Employee theEmployee);
	
	public void deleteEmployee(int id);
}
