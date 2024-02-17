package com.bookmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmanagement.model.Author;

@Repository
public interface AuthorRepo  extends JpaRepository<Author, Integer>{

}
