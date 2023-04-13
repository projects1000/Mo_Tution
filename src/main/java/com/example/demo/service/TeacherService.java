package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;

@Service
public interface TeacherService 
{
	List<Teacher> getAllTeacher();
	
	Teacher saveTeacher(Teacher teacher);

}
