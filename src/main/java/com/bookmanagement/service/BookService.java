package com.bookmanagement.service;

import java.awt.print.Pageable;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookmanagement.customexception.BookNotFoundException;
import com.bookmanagement.model.Book;
import com.bookmanagement.model.BookDto;
import com.bookmanagement.repo.BookRepo;


@Service
public  class BookService implements BookInf {

	@Autowired
	BookRepo bookrepo;
	
	@Override
	public String saveBooks(Book book) {
		try {
			bookrepo.save(book);
			return "Books are added successfully: "+book.getId();
		}catch (Exception e) {
			System.out.println(e);
			return "Something went Wrong";
		}	
	}

	@Override
	public List<Book> getAlls() {
		List<Book> book = bookrepo.findAll(Sort.by("id").descending());
//		List<Book> book1 = bookrepo.findAll(Sort.by("id").and(Sort.by("bookTitle")));
		return book;
	}

	@Override
	public Object getbyIds(int id) {
		 try {
			Optional<Book> bk =  bookrepo.findById(id);
			return bk;
			
		 }catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Book> getByYears(int publicationYear) {
		
		return bookrepo.findByPublicationYear(publicationYear);
	}

	@Override
	public List<Book> findBookYears(String bookTitle, int publicationYear) {
		return bookrepo.findByBookTitleAndPublicationYear(bookTitle, publicationYear);
	}

	@Override
	public List<Book> findBookTitles(String bookTitle) {
		return bookrepo.findByBookTitle(bookTitle);
	}

	@Override
	public Book updateDatas(Book books) {
		try {
//			bookrepo.save(books);
//			return bookrepo.findById(books.getId()).get();
			
			Book dbbook = bookrepo.getById(books.getId());
			books.setCreatedDate(dbbook.getCreatedDate());
			bookrepo.save(books);
			return bookrepo.getById(books.getId());
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Book> deleteByIds(int id) {
		Optional<Book> op = bookrepo.findById(id);
		if(op.isPresent()) {
			bookrepo.deleteById(id);
			return bookrepo.findAll();
		}else {
			throw new BookNotFoundException("Book Not found");
		}
	}

	@Override
	public BookDto fetchBySizeNumbers(int pageNumber, int pageSize) {
	    try {
	        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
	        Page<Book> page = bookrepo.findAll(pageable);
	        List<Book> books = page.getContent();

	        int totalBooks = (int) bookrepo.count();
	        BookDto dto = new BookDto();
	        dto.setBooks(books);
	        dto.setPageSize(pageSize);
	        dto.setPageNumber(pageNumber);
	        dto.setTotalElement(totalBooks);

	        int lastPage;

	        if (totalBooks % pageSize == 0) {
	            lastPage = totalBooks / pageSize;
	        } else {
	            lastPage = totalBooks / pageSize + 1;
	        }

	        if ((pageNumber + 1) == lastPage) {
	            dto.setLastPage(true);
	        } else {
	            dto.setLastPage(false);
	        }

	        return dto;
	    } catch (Exception e) {
	        System.out.println(e);
	        return null;
	    }
	}

	
	
	

}
