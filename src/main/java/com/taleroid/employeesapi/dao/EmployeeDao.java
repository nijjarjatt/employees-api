package com.taleroid.employeesapi.dao;

import java.util.List;

import com.taleroid.employeesapi.entity.Employee;

public interface EmployeeDao {
	public List<Employee> findAll();
}
  