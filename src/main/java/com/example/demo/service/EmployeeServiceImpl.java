package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeeRepo;

	
	@Override
	public Employee saveEmployee(Employee employee) {
	employeeRepo.save(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return employeeRepo.findAll();
	}

	@Override
	public Employee updateById(long id, Employee employee) {
		Employee employee2= employeeRepo.findById(id).get();
		employee2.setName(employee.getName());
		employee2.setAddress(employee.getAddress());
		return employeeRepo.save(employee2);
	}

	@Override
	public void deleteById(long id) {
		employeeRepo.deleteById(id);	
	
	}
}
