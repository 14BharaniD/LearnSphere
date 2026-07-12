package com.learnSphere.services;

import java.util.List;

import com.learnSphere.entities.Course;
import com.learnSphere.entities.Lesson;

public interface LessonService {
	
	String addLesson(Lesson lesson);
	
	List<Lesson> getLessons(Course course);
	
	Lesson getLesson(int lessonId);
	
	List<Lesson> getAllLessons();
	
	void deleteLesson(int lessonId);
	
	String updateLesson(Lesson lesson);
}
