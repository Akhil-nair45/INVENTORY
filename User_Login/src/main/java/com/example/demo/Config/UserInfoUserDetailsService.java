package com.example.demo.Config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepo ur;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User>user= ur.findByName(username);
		return user.map(UserInfoUserDetails::new)
		.orElseThrow(()->new  UsernameNotFoundException("User Not Found"+username));
	
	}

}
