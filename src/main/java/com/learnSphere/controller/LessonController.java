package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entities.Course;
import com.learnSphere.entities.Lesson;
import com.learnSphere.services.CommentService;
import com.learnSphere.services.CourseService;
import com.learnSphere.services.LessonService;

@Controller
public class LessonController {

	@Autowired
	LessonService lservice;
	
	@Autowired
	CourseService cservice;
	
	@Autowired
	CommentService commentService;
	
	@PostMapping("/addLesson")
	public String addLesson(@RequestParam("lessonId") int lessonId,
			                @RequestParam("lessonName") String lessonName,
			                @RequestParam("lessonTopics") String lessionTopics,
			                @RequestParam("lessonLink") String lessonLink,
			                @RequestParam("courseId") int courseId)
	{
		Course course = cservice.getCourse(courseId);
		
		Lesson lesson = new Lesson();
		
		
		lesson.setLessonId(lessonId);
		lesson.setLessonName(lessonName);
		lesson.setLessonTopics(lessionTopics);
		lesson.setLessonLink(lessonLink);
		lesson.setCourse(course);
		
		lservice.addLesson(lesson);
		return "trainerhome";	
		
	}
	
	@GetMapping("/viewLessons")
	
	public String viewLesson(@RequestParam("courseId") int courseId,Model model)
	{
		Course course = cservice.getCourse(courseId);
		
		List<Lesson> lessonList = lservice.getLessons(course);
		
		model.addAttribute("lessonList", lessonList);
		
		return "viewlessons";
	}
	
	@GetMapping("/viewLessonsTrainer")
	public String viewLessonsTrainer(Model model)
	{
		List<Lesson> lessonList = lservice.getAllLessons();
		model.addAttribute("lessonList", lessonList);
		return  "trainerviewlessons";
	}
	
	@GetMapping("/deleteLesson")
	public String deleteLesson(@RequestParam("lessonId") int lessonId)
	{
		
		Lesson lesson = lservice.getLesson(lessonId);
		commentService.deleteComments(lesson);
		lservice.deleteLesson(lessonId);
		return "redirect:/viewLessonsTrainer";
	}
	
	@GetMapping("/editLesson")
	public String editLesson(@RequestParam("lessonId") int lessonId,Model model)
	{
		Lesson lesson = lservice.getLesson(lessonId);
		model.addAttribute("lesson", lesson);
		return "lessonEdit";
	}
	
	@PostMapping("/updateLesson")
	public String updateLesson(
	        @RequestParam("lessonId") int lessonId,
	        @RequestParam("lessonName") String lessonName,
	        @RequestParam("lessonTopics") String lessonTopics,
	        @RequestParam("lessonLink") String lessonLink,
	        @RequestParam("courseId") int courseId)
	{
		Course course = cservice.getCourse(courseId);
		
		Lesson lesson = new Lesson();
		
		lesson.setLessonId(lessonId);
	    lesson.setLessonName(lessonName);
	    lesson.setLessonTopics(lessonTopics);
	    lesson.setLessonLink(lessonLink);
	    lesson.setCourse(course);
	    
	    lservice.updateLesson(lesson);
	    
	    return "redirect:/viewLessonsTrainer";
	}
}
