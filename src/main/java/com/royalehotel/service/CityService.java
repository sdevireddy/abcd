package com.royalehotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.model.City;
import com.royalehotel.model.User;
import com.royalehotel.repository.UserRepository;

@Service
public interface CityService {
	void save(City user);
	User findByCityName(String userName);
	
}
