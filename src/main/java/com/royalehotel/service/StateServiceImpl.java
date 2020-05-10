package com.royalehotel.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.exceptions.ValidationException;
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
	@Transactional
	public State save(State state) {
		if(!isValidState(state)) {
			throw new ValidationException("state code, name and countryid are manadatory");
		}
		if(state.getStatus().equals("1") && stateRepository.findByNameAndCode(state.getName(), state.getCode()) != null) {
			throw new ValidationException("state with this code and name already exists");			
		}
		if(state.getStatus().equals("0") && stateRepository.findByNameAndCode(state.getName(),state.getCode()) != null ) {
			List<State> states =  stateRepository.deleteByNameAndCode(state.getName(),state.getCode());
			return states.get(0);
		}else {
		stateRepository.save(state);
		}
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
	public List<State> findByCountryId(Long id) {
		return stateRepository.findByCountryId(id);
	}
	
	public boolean isValidState(State state) {
		if(state.getName() == null || state.getName().isEmpty())
			return false;
		if(state.getCode() == null || state.getCode().isEmpty())
			return false;
		if(state.getCountry() == null){
			return false;
		}
		
		return true;		
	}

}
