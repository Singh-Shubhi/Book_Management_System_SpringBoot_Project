package com.bookmanagement.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

//pihu@123 password
@Configuration
@EnableWebSecurity
public class SecurityConfigure  extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userservice;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userservice).passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().disable().authorizeRequests()
	        .antMatchers("/getAll", "/get/{id}", "/findYear/{publicationYear}", "/find/{bookTitle}/{publicationYear}", "/findTitle", "/fetch").hasAnyRole("ADMIN","USER")
	        .antMatchers("/book/save","/update", "/delete/{id}").hasRole("ADMIN")
	        .and()
	        .httpBasic();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/user/register");
	}

	
	
}