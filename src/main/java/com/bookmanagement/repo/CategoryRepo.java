package com.bookmanagement.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bookmanagement.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
