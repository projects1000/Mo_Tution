package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Teacher;
import com.example.demo.repo.TeacherRepo;

public class TeacherImpl  implements TeacherService
{

	 @Autowired
	    private TeacherRepo teacherRepo;
	 
	@Override
	public List<Teacher> getAllTeacher() {
		
		
		return teacherRepo.findAll();
	}

	

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		teacherRepo.save(teacher);
		return teacher;
	}

}
