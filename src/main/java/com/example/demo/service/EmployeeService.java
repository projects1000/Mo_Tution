package com.example.demo.service;

import java.util.*;

import com.example.demo.entity.Employee;

public interface EmployeeService 
{
	
	Employee saveEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	Employee updateById(long id, Employee employee);

	void deleteById(long id);

}
