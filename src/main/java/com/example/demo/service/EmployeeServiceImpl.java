package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.controller.EmployeeController;
import com.example.demo.dto.EmployeeLogin;
import com.example.demo.entity.Employee;
import com.example.demo.logger.Lgr;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	private Logger logger =Lgr.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	public Employee createUser(Employee employee)
	{
		String methodName="postDetails(@RequestBody Employee employee) ";
		logger.info(methodName + "called");
		employee.setPassword(passwordEncode.encode(employee.getPassword()));
		employee.setRole("ROLE_EMPLOYEE");
		return employeeRepo.save(employee);
	}
	
	@Override
	public Employee saveEmployee(Employee employee)
	{
	employeeRepo.save(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee()
	{
		String methodName="getAllEmployee()";
		logger.info(methodName + "called");
		
		return employeeRepo.findAll();
	}

	@Override
	public Employee updateById(long id, Employee employee)
	{
		String methodName="updateDetails() ";
		logger.info(methodName + "called");
		
		Employee employee2= employeeRepo.findById(id).get();
		employee2.setName(employee.getName());
		employee2.setAddress(employee.getAddress());
		return employeeRepo.save(employee2);
	}

	@Override
	public void deleteById(long id) 
	{
		String methodName="deleteDetails() ";
		logger.info(methodName + "called");
		
		employeeRepo.deleteById(id);	
	
	}

	@Override
	public Employee createEmployee(Employee employee)
	{
		String methodName="createEmployee() ";
		logger.info(methodName + "called");
		
		return employeeRepo.save(employee);
	}

	@Override
	public Employee checkEmail(String email)
	{
		return employeeRepo.findByEmail(email);
	}

	@Override
	public Employee registerEmployee(Employee employee) {
		String methodName="register() ";
		logger.info(methodName + "called");
		return employeeRepo.save(employee);
	}

	@Override
	public Employee loginEmployee(EmployeeLogin employeeLogin) {
		String methodName="loginuser() ";
		logger.info(methodName + "called");
	
		Employee email = employeeRepo.findByEmail(employeeLogin.getEmail());
		if (email !=null)
		{
			if(email.getEmail().equals(employeeLogin.getEmail()) && email.getPassword().equals(employeeLogin.getPasssword())) {
				
				return email;
			}else {
				return null;
			}
		}
		
		return null;
	}
	
	
	
	}
