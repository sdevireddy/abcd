package com.royalehotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royalehotel.model.CarDetails;
import com.royalehotel.model.City;

public interface CarDetailsRepositiory extends JpaRepository<CarDetails, Long> {
}
