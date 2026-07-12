package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entities.Course;
import com.learnSphere.repositories.CourseRepository;

@Service
public class CourseServiceImplementation implements CourseService{

	@Autowired
	CourseRepository repo;
	@Override
	public String addCourse(Course course) {
	
		repo.save(course);
		return "course added!";
	}
	@Override
	public List<Course> getAllCourses() {
	
		 return repo.findAll();
	}
	@Override
	public Course getCourse(int courseId) {
				
		return repo.findById(courseId).get();
	}
	@Override
	public String updateCourse(Course course) {
		repo.save(course);
		return "Course Updated";
	}
	

}
