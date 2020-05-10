package com.royalehotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.model.City;
import com.royalehotel.repository.CityRepositiory;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepositiory cityRepository;

	@Override
	public City save(City city) {
		 cityRepository.save(city);
		 return city;
	}

	@Override
	public List<City> findByCityName(String cityName) {
		return cityRepository.findByName(cityName);		
	}
	
	@Override
	public List<City> findAll(){
		return cityRepository.findAll();
	}
	
	@Override
	public List<City> findByStateId(Long stateId){
		return cityRepository.findByStateId(stateId);
	}

}
