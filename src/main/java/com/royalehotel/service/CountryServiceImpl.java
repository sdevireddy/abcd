package com.royalehotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.model.Country;
import com.royalehotel.model.User;
import com.royalehotel.repository.CountryRepositiory;
import com.royalehotel.repository.UserRepository;

@Service
public class CountryServiceImpl implements ContryService {

	@Autowired
	CountryRepositiory countryRepository;

	@Override
	public Country save(Country country) {
		return countryRepository.save(country);
	}

	@Override
	public Country findByName(String userName) {
		return countryRepository.findByName(userName);
	}

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public Optional<Country> findById(Long id) {
		return countryRepository.findById(id);
	}

}
