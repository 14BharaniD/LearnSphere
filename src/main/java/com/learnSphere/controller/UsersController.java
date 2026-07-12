package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.learnSphere.entities.Users;
import com.learnSphere.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	
	@Autowired
	UsersService uservice;	
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute Users user)
	{
		uservice.addUser(user);
		return "login";
	}
	
	@PostMapping("/validateUser")
	public String validateUser(@RequestParam("email")String email,
			@RequestParam("password")String password,HttpSession session)
	{
		
		Users user = uservice.getUser(email);
		if(user != null && user.getPassword().equals(password))
		{
			session.setAttribute("email", email);
			if(user.getRole().equals("Trainer"))
			{
				return "trainerhome";
			}
			else 
			{
			 return "studenthome";
			}
		}
		return "login";
	}
	
	
	
}
