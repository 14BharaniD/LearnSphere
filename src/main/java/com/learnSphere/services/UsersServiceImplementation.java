package com.learnSphere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entities.Users;
import com.learnSphere.repositories.UsersRepository;


@Service
public class UsersServiceImplementation implements UsersService {
	@Autowired
	UsersRepository repo;
	
	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "user added!";
	}

	@Override
	public Users getUser(String email) {
		
		return repo.findByEmail(email);
	}
	
}
