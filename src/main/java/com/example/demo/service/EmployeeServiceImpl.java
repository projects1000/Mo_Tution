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
	public void register(Employee employee) {
		employeeRepo.save(employee);
		
	}

	public List<Employee> getAllEmployee() {
		
		return employeeRepo.findAll();
	}


	public Employee saveDetails(Employee employee) {
		
		return employeeRepo.save(employee);
	}

	public void deleteDetailsbyId(long id) {
		employeeRepo.deleteById(id);
		
	}

	public void updateDetails(long id, Employee employee) {
		Employee employee2 = employeeRepo.findById(id).get();
		employee2.setAddress(employee.getAddress());
		employee2.setName(employee.getName());
		
	}
	
	

}
