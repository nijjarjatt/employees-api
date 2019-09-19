package com.taleroid.employeesapi.rest;

import com.taleroid.employeesapi.dao.EmployeeDao;
import com.taleroid.employeesapi.entity.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeController(EmployeeDao theEmployeeDao) {
		employeeDao = theEmployeeDao;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
}
