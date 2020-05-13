package com.royalehotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royalehotel.model.Country;

public interface CountryRepositiory extends JpaRepository<Country, Long> {
	Country findByName(String name);
	Country findByCode(String code);
	Country findByNameAndCode(String name,String code);
	List<Country> deleteByName(String name);	
	void deleteById(Long id);
}
