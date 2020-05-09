package com.royalehotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.model.City;
import com.royalehotel.model.User;
import com.royalehotel.repository.CityRepositiory;
import com.royalehotel.repository.UserRepository;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepositiory cityRepository;

	@Override
	public void save(City city) {
		cityRepository.save(city);
	}

	@Override
	public User findByCityName(String cityName) {
		return null;
	}

}
