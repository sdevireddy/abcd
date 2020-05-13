package com.royalehotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.model.City;
import com.royalehotel.model.User;
import com.royalehotel.repository.UserRepository;

@Service
public interface CityService {
	City save(City city);
	List<City> findByCityName(String cityName);
	List<City> findAll();
	List<City> findByStateId(Long stateId);	
}
