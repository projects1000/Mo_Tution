package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.demo.dto.EmployeeLogin;
import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	
	public Employee createUser(Employee employee)
	{
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
		
		return employeeRepo.findAll();
	}

	@Override
	public Employee updateById(long id, Employee employee)
	{
		Employee employee2= employeeRepo.findById(id).get();
		employee2.setName(employee.getName());
		employee2.setAddress(employee.getAddress());
		return employeeRepo.save(employee2);
	}

	@Override
	public void deleteById(long id) 
	{
		employeeRepo.deleteById(id);	
	
	}

	@Override
	public Employee createEmployee(Employee employee)
	{
		
		return employeeRepo.save(employee);
	}

	@Override
	public Employee checkEmail(String email)
	{
		return employeeRepo.findByEmail(email);
	}

	@Override
	public Employee registerEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee loginEmployee(EmployeeLogin employeeLogin) {
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
