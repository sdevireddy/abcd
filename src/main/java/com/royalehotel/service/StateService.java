package com.royalehotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royalehotel.model.Country;
import com.royalehotel.model.State;
import com.royalehotel.model.User;
import com.royalehotel.repository.UserRepository;

@Service
public interface StateService {
	State save(State user);

	State findByName(String userName);

	Optional<State> findById(Long id);

	List<State> findByCountryId(Long id);

	List<State> findAll();

}
