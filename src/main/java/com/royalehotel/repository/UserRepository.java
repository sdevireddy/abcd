package com.royalehotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royalehotel.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
