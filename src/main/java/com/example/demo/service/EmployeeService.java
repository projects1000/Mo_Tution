package com.example.demo.service;

import java.util.*;

import org.slf4j.Logger;

import com.example.demo.controller.EmployeeController;
import com.example.demo.dto.EmployeeLogin;
import com.example.demo.entity.Employee;
import com.example.demo.logger.Lgr;

public interface EmployeeService 
{
	
	

	public List<Employee> getAllEmployee() ;
	
	
	

	Employee updateById(long id, Employee employee);

	void deleteById(long id);
	
	public Employee createEmployee(Employee employee);
	
	public Employee checkEmail(String email);

	public Employee registerEmployee(Employee employee);

	Employee saveEmployee(Employee employee);

	public Employee loginEmployee(EmployeeLogin employeeLogin);
	

}
