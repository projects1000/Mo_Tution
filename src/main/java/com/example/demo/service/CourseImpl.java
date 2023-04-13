package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Teacher;
import com.example.demo.repo.CourseRepo;
import com.example.demo.repo.TeacherRepo;

@Service
public class CourseImpl implements CourseService {
	  @Autowired
	    private CourseRepo courseRepository;
	  
	  @Autowired
	  private TeacherRepo teacherRepo;
	  
	  
@Override
	  public List<Course> getAllCourse()
		{
			
			return courseRepository.findAll();
		}

@Override
public Course  createCourse(Course course)
{
	
	return courseRepository.save(course);
}



@Override
public Course saveCourse(Course course) {
	
	
	Course c = new Course();
	c.setFee(course.getFee());
	c.setName(course.getName());
	Set<Teacher> teachers = new HashSet<>();
	for (Teacher teacher : course.getTeachers()) {
	    Teacher t = new Teacher();
	    t.setEmail(teacher.getEmail());
	    t.setMobile_no(teacher.getMobile_no());
	    t.setName(teacher.getName());
	    teacherRepo.save(t);
	    teachers.add(t);
	}
	c.setTeachers(teachers);
	courseRepository.save(c);

	return c;
	
}

@Override
public Course getCourseByID(long id) {
	Course orElseThrow = courseRepository.findById(id).orElseThrow(null);
	return orElseThrow;
}


}
