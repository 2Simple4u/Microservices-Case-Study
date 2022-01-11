package com.spring.security.itransformsecurity.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.itransformsecurity.model.ApplicationUserDao;

// using Spring security for implementing the userDetailsService

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	private final ApplicationUserDao applicationUserDao;
	
	
	// creating constructor
	public MyUserDetailsService(ApplicationUserDao applicationUserDao) {
		this.applicationUserDao = applicationUserDao;
	}

	// using UserDetailsService methods
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return applicationUserDao.selectApplicationByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException(String.format("Username %s not found", username)));
	}

}
