package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Employee;

@Service
public interface CourseService {
	   

	List<Course> getAllCourse();
	
	
	Course createCourse(Course course);


	Course saveCourse(Course course);


	Course getCourseByID(long id);

}
