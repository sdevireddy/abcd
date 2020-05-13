package com.royalehotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royalehotel.model.State;

public interface StateRepositiory extends JpaRepository<State, Long> {

	public State findByName(String name);
	public State findByNameAndCode(String name,String code);
	public Optional<State> findById(Long id);
	public State findAllByCountryId(Long countryId);
	public List<State> findByCountryId(Long id);
	public List<State> deleteByNameAndCode(String name, String code);
}
