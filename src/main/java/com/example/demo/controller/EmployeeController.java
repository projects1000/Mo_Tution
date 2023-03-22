package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeServiceImpl;

@RestController

public class EmployeeController 
{
	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/hyy")
		public List<Employee> getAllEmployee()
	{
		return employeeServiceImpl.getAllEmployee();
		
	}
	
	@PostMapping("/add")
	public Employee postDetails(@RequestBody Employee employee)
	{
		return employeeServiceImpl.saveDetails(employee);
	}
	
	@DeleteMapping("/{id}")
	public String deleteDetails(@PathVariable("id")long id) {
		employeeServiceImpl.deleteDetailsbyId(id);
		return "Data is deleted: "+id;
	}
	
	@PutMapping("/update/{id}")
	public String updateDetails(@PathVariable("id") long id, @RequestBody Employee employee) {
		
		employeeServiceImpl.updateDetails(id,employee);
		return "Your data is updated...";
	}
		
		
		
	    
}
