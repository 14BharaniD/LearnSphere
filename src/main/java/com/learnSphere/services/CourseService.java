package com.learnSphere.services;

import java.util.List;

import com.learnSphere.entities.Course;

public interface CourseService {
	String addCourse(Course course);
	
	List<Course> getAllCourses();
	
	Course getCourse(int courseId);
	
	String updateCourse(Course course);
}
