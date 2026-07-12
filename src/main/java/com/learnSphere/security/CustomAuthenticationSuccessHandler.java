package com.learnSphere.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
            throws IOException, ServletException {
    	
    	CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
    	request.getSession().setAttribute("email",userDetails.getUsername());
    	String role = userDetails.getUser().getRole();
    	if(role.equals("Trainer")) {
    	    response.sendRedirect("/trainerhome");
    	}
    	else {
    	    response.sendRedirect("/studenthome");
    	}
    }

}