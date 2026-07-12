package com.learnSphere.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.learnSphere.security.CustomAuthenticationSuccessHandler;
import com.learnSphere.services.CustomUserDetailsService;


@Configuration
public class SecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> auth
            .requestMatchers(
                "/",
                "/login",
                "/register",
                "/addUser",
                "/validateUser",
                "/css/**",
                "/images/**"
            ).permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
        	    .loginPage("/login")
        	    .loginProcessingUrl("/login")
        	    .successHandler(successHandler)
        	    .failureUrl("/login?error")
        	    .permitAll()
        )
        .authenticationProvider(authenticationProvider());

        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider()
    {
    	DaoAuthenticationProvider provider =
    	        new DaoAuthenticationProvider((UserDetailsService) customUserDetailsService);
    	provider.setPasswordEncoder(passwordEncoder());
		return provider;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {

        return NoOpPasswordEncoder.getInstance();

    }
}