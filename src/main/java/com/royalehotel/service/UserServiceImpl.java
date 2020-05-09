package com.royalehotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.model.User;
import com.royalehotel.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public User findByUserName(String userName) {
		return null;
	}

	public User findByPhoneNumber(String phoneNumber) {
		return null;
	}

	@Override
	public List<User> fetchUsers() {
		return userRepository.findAll();
	}

}
