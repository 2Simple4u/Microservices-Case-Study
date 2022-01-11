package com.spring.security.itransformsecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.security.itransformsecurity.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private MyUserDetailsService userService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// In-Memory
		auth.inMemoryAuthentication()
		.withUser("admin").password(passwordEncoder().encode("admin")).roles("USER","ADMIN");
		
		// database Auth
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.formLogin()
		      .loginPage("/login");
		      
	}
	
}
