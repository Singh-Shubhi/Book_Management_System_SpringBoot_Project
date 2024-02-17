package com.bookmanagement.repo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bookmanagement.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer> {

	public List<Book> findByPublicationYear(int publicationYear);
	
	public List<Book> findByBookTitleAndPublicationYear(String bookTitle, int publicationYear);
	
	@Query(value="select * from Book where book_title = :book_title" , nativeQuery = true)
	public List<Book> findByBookTitle(@Param("book_title") String bookTitle);
}
