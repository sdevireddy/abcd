package com.royalehotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royalehotel.model.CarType;
import com.royalehotel.model.City;

public interface CarTypeRepositiory extends JpaRepository<CarType, Long> {

}
