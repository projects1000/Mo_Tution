package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepository;

@Controller
@RequestMapping("/user/")
public class UserController 
{
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@ModelAttribute
	private void userDetails(Model m,Principal p)
	{
		String email=p.getName();
		Employee employee=employeeRepo.findByEmail(email);
		m.addAttribute("employee", employee);
	}
	
	
	@GetMapping("/")
	public String home()
	{
		return null;//we have return a html page at point of null
	}

}
