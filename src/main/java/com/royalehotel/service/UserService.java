package com.royalehotel.service;

import java.util.List;

import com.royalehotel.model.User;

public interface UserService {
	User save(User user);
	List<User> fetchUsers();

}
