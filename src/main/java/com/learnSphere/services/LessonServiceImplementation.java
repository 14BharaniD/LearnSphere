package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entities.Course;
import com.learnSphere.entities.Lesson;
import com.learnSphere.repositories.LessonRepository;

@Service
public class LessonServiceImplementation implements LessonService{

	@Autowired
	LessonRepository repo;
	
	@Override
	public String addLesson(Lesson lesson) {
	
		repo.save(lesson);
		return "Lesson Added";
	}

	@Override
	public List<Lesson> getLessons(Course course) {
		
		return repo.findByCourse(course);
		
	}

	@Override
	public Lesson getLesson(int lessonId) {
		return repo.findById(lessonId).get();
	}

	@Override
	public List<Lesson> getAllLessons() {
		return repo.findAll();
	}

	@Override
	public void deleteLesson(int lessonId) {
		repo.deleteById(lessonId);
	}

	@Override
	public String updateLesson(Lesson lesson) {
		// TODO Auto-generated method stub
		repo.save(lesson);
		return "Updated Successfully";
	}

}
