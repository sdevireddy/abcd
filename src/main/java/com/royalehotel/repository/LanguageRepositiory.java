package com.royalehotel.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royalehotel.model.Language;

public interface LanguageRepositiory extends JpaRepository<Language, Long> {

	Language save(Language language);	
	List<Language> findAll();
	List<Language> findByNameAndCode(String name, String code);
	List<Language> deleteByNameAndCode(String name, String code);
	void deleteById(Long id);
	Optional<Language> findById(Long id);
}
