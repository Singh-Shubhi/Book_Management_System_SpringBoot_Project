package com.bookmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmanagement.model.Language;

@Repository
public interface LanguageRepo extends JpaRepository<Language, Integer> {

}
