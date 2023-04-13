package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
	public class Course {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		
		private long id;
		private String name;
		private String fee;
	
		
		
		@ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(name="course_teachers",
		           joinColumns = @JoinColumn(name="course_id", referencedColumnName = "id"),
		           inverseJoinColumns = @JoinColumn(name="teacher_id", referencedColumnName = "id")
				)
		private Set<Teacher> teachers;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFee() {
		return fee;
	}


	public void setFee(String fee) {
		this.fee = fee;
	}


	public Set<Teacher> getTeachers() {
		return teachers;
	}


	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", fee=" + fee + ", teachers=" + teachers + "]";
	}
	
	
	
	
	

	
}
