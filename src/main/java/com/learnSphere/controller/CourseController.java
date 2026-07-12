package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entities.Course;
import com.learnSphere.entities.Users;
import com.learnSphere.services.CourseService;
import com.learnSphere.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CourseController {

	@Autowired
	UsersService uservice;
	
	@Autowired
	CourseService cservice;
	
	@PostMapping("/addCourse")
	public String addCourse(@ModelAttribute Course course)
	{
		cservice.addCourse(course);
		
		
		return "trainerhome";
	}
	
	@GetMapping("/viewCourses")
	
	public String viewCourses(Model model)
	{
		List<Course> courseList=cservice.getAllCourses();
		model.addAttribute("courseList", courseList);
		return "viewcourses";
	}
	
	@GetMapping("/purchase")
	
	public String purchase(Model model)
	{
		List<Course> courseList = cservice.getAllCourses();
		model.addAttribute("courseList", courseList);
		return "purchase";
	}
	
	@GetMapping("/buyCourse")
	
	public String buyCourse(@RequestParam int courseId,Model model)
	{
		Course course = cservice.getCourse(courseId);
		
		model.addAttribute("course", course);
		
		return "payment";
	}
	
	@GetMapping("/purchaseCourse")
	public String purchaseCourse(@RequestParam("courseId") int courseId,HttpSession session)
	{
		String email = (String)session.getAttribute("email");
		Users user = uservice.getUser(email);
		Course course = cservice.getCourse(courseId);
		user.getCourseList().add(course);
		uservice.addUser(user);
		return "studenthome";
	}
	
	@GetMapping("/mycourses")
	public String mycourses(HttpSession session , Model model)
	{
		String email = (String)session.getAttribute("email");
		Users user = uservice.getUser(email);
		model.addAttribute("courseList", user.getCourseList());
		return "mycourses";
	}
	
	@GetMapping("/editCourse")
	public String editCourse(@RequestParam("courseId") int courseId,Model model)
	{
		Course course = cservice.getCourse(courseId);
		model.addAttribute("course", course);
		return "editcourse";
	}
	
	@PostMapping("/updateCourse")
	public String updateCourse(
	        @RequestParam("courseId") int courseId,
	        @RequestParam("courseName") String courseName,
	        @RequestParam("coursePrice") int coursePrice)
	{
	    Course course = new Course();

	    course.setCourseId(courseId);
	    course.setCourseName(courseName);
	    course.setCoursePrice(coursePrice);

	    cservice.updateCourse(course);

	    return "redirect:/viewCourses";
	}
	
}
