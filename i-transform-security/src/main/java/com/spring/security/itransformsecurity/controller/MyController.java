package com.spring.security.itransformsecurity.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins="*")
public class MyController {
	
	@RequestMapping({"/auth"})
	public String getName() {
		return "hellow world";
	}

}
