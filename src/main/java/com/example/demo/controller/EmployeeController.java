package com.example.demo.controller;

import java.util.*;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeLogin;
import com.example.demo.entity.Course;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Teacher;
import com.example.demo.repo.CourseRepo;
import com.example.demo.repo.TeacherRepo;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;

@RestController

public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/hyy")
	public List<Employee> getAllEmployee() {
		LOGGER.info("getting All employees");
		return employeeService.getAllEmployee();

	}

	@PostMapping("/add")
	public Employee postDetails(@RequestBody Employee employee) {
		LOGGER.info("adding employee");
		return employeeService.saveEmployee(employee);
	}

	@DeleteMapping("/{id}")
	public String deleteDetails(@PathVariable("id") long id) {
		LOGGER.info("Deleting employee by id");
		employeeService.deleteById(id);
		return "Data is deleted: " + id;
	}

	@PutMapping("/update/{id}")
	public String updateDetails(@PathVariable("id") long id, @RequestBody Employee employee) {
		LOGGER.info("updating employee");
		employeeService.updateById(id, employee);
		return "Your data is updated...";
	}

	@GetMapping("/index")
	public String index() {
		return (null);
	}



	@PostMapping("/login1")
	public String loginuser(@RequestBody EmployeeLogin employeeLogin) {
		
		
		LOGGER.info("logging in the employee");
	
		Employee loginEmployee = employeeService.loginEmployee(employeeLogin);

		if (loginEmployee != null) {
			return "Welcome";
		}

		return "Invalid Credential";
	}

	@PostMapping("/register")
	public String register(@RequestBody Employee employee) {
		LOGGER.info("Registering employee");
		Employee e = employeeService.registerEmployee(employee);
		return "SUccessfully Registered";
	}

	@PostMapping("/createUser")
	public String createEmployee(@ModelAttribute Employee employee, HttpSession session) {
		
		LOGGER.info("creating an saving bsed on email of employee");
		Employee e = employeeService.checkEmail(employee.getEmail());
		if (e.getEmail() != null) {
			session.setAttribute("message", "This Mail id already exist");
		}

		else {

			Employee employee_1 = employeeService.createEmployee(employee);
			if (employee_1 != null) {
				session.setAttribute("message", "Successfully registered");
			} else {
				session.setAttribute("message", "Something is Wrong");
			}
		}
		return "redirect:/null";
	}
	
	
	}
	

