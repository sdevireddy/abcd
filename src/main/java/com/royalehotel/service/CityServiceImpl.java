package com.royalehotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.exceptions.ValidationException;
import com.royalehotel.model.City;
import com.royalehotel.model.Language;
import com.royalehotel.repository.CityRepositiory;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepositiory cityRepository;

	@Override
	public City save(City city) {	
		if (!isValid(city)) {
			throw new ValidationException("code, name are manadatory");
		}
		if (city.getStatus().equals("1")
				&& cityRepository.findByNameAndCode(city.getName(), city.getCode()).size() > 0) {
			throw new ValidationException("city with this code and name already exists");
		}
		if (city.getStatus().equals("0") && cityRepository.findById(city.getId()) != null) {
			cityRepository.deleteById(city.getId());
			return city;
		} else {
			return cityRepository.save(city);
		}

	}

	@Override
	public List<City> findByCityName(String cityName) {
		return cityRepository.findByName(cityName);
	}

	@Override
	public List<City> findAll() {
		return cityRepository.findAll();
	}

	@Override
	public List<City> findByStateId(Long stateId) {
		return cityRepository.findByStateId(stateId);
	}

	public boolean isValid(City city) {
		if (city.getName() == null || city.getName().isEmpty())
			return false;
		if (city.getCode() == null || city.getCode().isEmpty())
			return false;
		return true;
	}

}
