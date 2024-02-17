package com.bookmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookmanagement.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
}
