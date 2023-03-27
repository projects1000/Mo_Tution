package com.example.demo.service;

import java.util.*;

import com.example.demo.entity.Employee;

public interface EmployeeService 
{
	
	public Employee saveEmployee(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee updateById(long id, Employee employee);

	public void deleteById(long id);

}
