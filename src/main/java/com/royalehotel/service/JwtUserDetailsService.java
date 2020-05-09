package com.royalehotel.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	public UserDetails loadUserByUsername(String userName) {
		// String encoded = new BCryptPasswordEncoder().encode(plainTextPassword);
		if ("siva".equalsIgnoreCase(userName)) {
			return new User("siva", new BCryptPasswordEncoder().encode("password"), new ArrayList());
		} else {
			throw new UsernameNotFoundException("User Not found Exception");
		}
	}

}
