package com.learnSphere.services;

import com.learnSphere.entities.Users;

public interface UsersService {
	
	String addUser(Users user);
	
	Users getUser(String email);
}
