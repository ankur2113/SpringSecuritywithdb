package com.reset.SpringSecuritywithdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reset.SpringSecuritywithdb.entity.CustomUserDetails;
import com.reset.SpringSecuritywithdb.entity.User;
import com.reset.SpringSecuritywithdb.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userrepository.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException(username+" was not found");
		}
		return new CustomUserDetails(user);
	}

}
