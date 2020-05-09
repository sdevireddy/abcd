package com.royalehotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.model.Country;
import com.royalehotel.model.State;
import com.royalehotel.model.User;
import com.royalehotel.repository.CountryRepositiory;
import com.royalehotel.repository.StateRepositiory;
import com.royalehotel.repository.UserRepository;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepositiory stateRepository;

	@Autowired
	CountryRepositiory countryRepository;

	@Override
	public State save(State state) {
		stateRepository.save(state);
		return state;
	}

	@Override
	public State findByName(String name) {
		return stateRepository.findByName(name);
	}

	public Country findByCountryName(String name) {
		return countryRepository.findByName(name);
	}

	/*
	 * @Override public Country findByCountryId(Long id) { return
	 * countryRepository.findByCountryId(id);
	 * 
	 * }
	 */
	
	

	@Override
	public Optional<State> findById(Long id) {
		return stateRepository.findById(id);
	}

	@Override
	public List<State> findAll() {
		return stateRepository.findAll();
	}

	@Override
	public Optional<State> findByCountryId(Long id) {
		return stateRepository.findByCountryId(id);
	}

}
