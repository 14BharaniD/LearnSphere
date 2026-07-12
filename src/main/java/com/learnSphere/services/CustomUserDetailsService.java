package com.learnSphere.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.learnSphere.entities.Users;
import com.learnSphere.repositories.UsersRepository;
import com.learnSphere.security.CustomUserDetails;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	    Users user = repo.findByEmail(username);

	    if (user == null) {
	        throw new UsernameNotFoundException("User Not Found");
	    }

	    return new CustomUserDetails(user);
	}

}
