package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long>
{
	List<Teacher>findTeacherById(Long id);
	
	

}
