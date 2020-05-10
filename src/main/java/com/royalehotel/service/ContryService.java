package com.royalehotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.model.Country;
import com.royalehotel.model.User;
import com.royalehotel.repository.UserRepository;

@Service
public interface ContryService {
	Country save(Country country);

	Country findByName(String countryName);
	List<Country> findAll();

	Optional<Country> findById(Long id);
	boolean isValidCountry(Country country);

	Country findByCode(String code);

}
