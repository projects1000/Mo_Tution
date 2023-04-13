package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Course;

@Repository
public interface CourseRepo  extends JpaRepository<Course, Long>
{
	List<Course>findCourseById(Long id);
	

}
