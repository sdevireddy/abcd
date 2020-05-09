package com.royalehotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royalehotel.model.State;

public interface StateRepositiory extends JpaRepository<State, Long> {

	public State findByName(String name);
	public Optional<State> findByCountryId(Long id);
}
