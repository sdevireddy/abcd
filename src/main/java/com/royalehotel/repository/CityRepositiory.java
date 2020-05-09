package com.royalehotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royalehotel.model.City;

public interface CityRepositiory extends JpaRepository<City, Long> {
	public List<City> findByCityName(String name);

}