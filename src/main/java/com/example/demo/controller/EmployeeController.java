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
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;

@RestController

public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/hyy")
		public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
		
	}
	
	@PostMapping("/add")
	public Employee postDetails(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}
	
	@DeleteMapping("/{id}")
	public String deleteDetails(@PathVariable("id")long id) {
		employeeService.deleteById(id);
		return "Data is deleted: "+id;
	}
	
	@PutMapping("/update/{id}")
	public String updateDetails(@PathVariable("id") long id, @RequestBody Employee employee) {
		
		employeeService.updateById(id,employee);
		return "Your data is updated...";
	}
		
}
