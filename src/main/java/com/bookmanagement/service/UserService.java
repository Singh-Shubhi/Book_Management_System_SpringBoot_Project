package com.bookmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookmanagement.model.User;
import com.bookmanagement.model.UserDTO;
import com.bookmanagement.repo.UserRepo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepo userrepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return userrepo.findByUsername(username);
	}
	
	public UserDTO saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userrepo.save(user);
//		return userrepo.findByUsername(user.getUsername());
		
		UserDTO udto = new UserDTO();
		udto.setUsername(user.getUsername());
		udto.setEmail(user.getEmail());
		udto.setAge(user.getAge());
		return udto;
	}
	
	

}
