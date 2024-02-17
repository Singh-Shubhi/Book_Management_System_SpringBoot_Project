package com.bookmanagement.service;

import java.util.List;

import com.bookmanagement.model.Book;
import com.bookmanagement.model.BookDto;

public interface BookInf {

	public String saveBooks(Book book);

	public List<Book> getAlls();

	public Object getbyIds(int id);

	public List<Book> getByYears(int publicationYear);

	public List<Book> findBookYears(String bookTitle, int publicationYear);

	public List<Book> findBookTitles(String bookTitle);

	public Book updateDatas(Book books);

	public List<Book> deleteByIds(int id);

	public BookDto fetchBySizeNumbers(int pageNumber, int pageSize);

	

}
