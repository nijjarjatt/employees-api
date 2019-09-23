package com.taleroid.employeesapi.rest;

import com.taleroid.employeesapi.entity.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import com.taleroid.employeesapi.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{emplpyeeId}")
	public ResponseEntity<Object> getEmployee(@PathVariable int emplpyeeId) {
		Employee currentEmplpyee = employeeService.findById(emplpyeeId);
		
		if(currentEmplpyee == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Empoyee not found");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(currentEmplpyee);
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		newEmployee.setId(0);
		
		employeeService.saveEmployee(newEmployee);
		
		return newEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee newEmployee) {
		
		employeeService.saveEmployee(newEmployee);
		
		return newEmployee;
	}
	
	
}
