package com.royalehotel.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.exceptions.ValidationException;
import com.royalehotel.model.Country;
import com.royalehotel.model.User;
import com.royalehotel.repository.CountryRepositiory;
import com.royalehotel.repository.UserRepository;

@Service
public class CountryServiceImpl implements ContryService {

	@Autowired
	CountryRepositiory countryRepository; 

	@Override
	@Transactional
	public Country save(Country country) {	
		if(!isValidCountry(country)) {
			throw new ValidationException("country code and name are manadatory");
		}
		if(country.getStatus().equals("1") && countryRepository.findByNameAndCode(country.getName(), country.getCode()) != null) {
			throw new ValidationException("country already exists");			
		}
		if(country.getStatus().equals("0") && countryRepository.findById(country.getId()) != null ) {
			countryRepository.deleteById(country.getId());
			return country;
		}else {
		return countryRepository.save(country);
		}
	}

	@Override
	public Country findByName(String userName) {
		return countryRepository.findByName(userName);
	}
	
	@Override
	public Country findByCode(String code) {
		return countryRepository.findByCode(code);
	}

	@Override
	public List<Country> findAll() {
		return countryRepository.findAll();
	}

	@Override
	public Optional<Country> findById(Long id) {
		return countryRepository.findById(id);
	}
	
	public boolean isValidCountry(Country country) {
		if(country.getName() == null || country.getName().isEmpty())
			return false;
		if(country.getCode() == null || country.getCode().isEmpty())
			return false;
		
		return true;		
	}
	
	

}
