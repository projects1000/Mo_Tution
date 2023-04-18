package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;
import com.example.demo.logger.Lgr;
import com.example.demo.repo.CourseRepo;
import com.example.demo.repo.TeacherRepo;
import com.example.demo.service.CourseService;

@RestController
public class CourseTeacher 
{
	private Logger logger =Lgr.getLogger(CourseTeacher.class);
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherRepo teacherRepo;
	
	
	
	@PostMapping("/course")
	public Course saveCourse(@RequestBody Course course)
	{
		String methodName="saveCourse() ";
		logger.info(methodName + "called");
		return courseService.saveCourse(course);
	}
	

	
	@GetMapping("course/{id}")
    public Course getCourseByID(@PathVariable long id) {
		
		String methodName="getCourseByID() ";
		logger.info(methodName + "called");
		
		return courseService.getCourseByID(id);
	}
	
		
}
