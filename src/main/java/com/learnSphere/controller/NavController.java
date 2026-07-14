package com.learnSphere.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavController {
	
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/addCourse")
	public String addCourse()
	{
		return "courseAdd";
	}
	
	@GetMapping("/addLesson")
	public String addLesson()
	{
		return "lessonAdd";
	}
	
	@GetMapping("/logout")
		public String logout(HttpSession session)
		{
			session.invalidate();
			return "login";
		}
	
	@GetMapping("/trainerhome")
	public String trainerHome() {
	    return "trainerhome";
	}
	
	@GetMapping("/studenthome")
	public String studentHome() {
	    return "studenthome";
	}
}
