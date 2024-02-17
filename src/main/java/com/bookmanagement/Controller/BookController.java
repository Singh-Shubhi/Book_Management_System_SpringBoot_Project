package com.bookmanagement.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmanagement.model.Book;
import com.bookmanagement.model.BookDto;
import com.bookmanagement.service.BookInf;


@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "*")
public class BookController {

	@Autowired
	BookInf bookservice;
	
	@PostMapping("/save")
	public String saveBook(@RequestBody @Valid Book book) {
		return bookservice.saveBooks(book);
		 
	}
	
	@GetMapping("/getAll")
	public List<Book> getAll(){
		return bookservice.getAlls();
	}
	
	@GetMapping("/get/{id}")
	public Object getbyId(@PathVariable int id) {
		return bookservice.getbyIds(id);
	}
	
	
	@GetMapping("/findYear/{publicationYear}")
	public List<Book> getByYear(@PathVariable int publicationYear) {
		return bookservice.getByYears(publicationYear);
	}
	
	@GetMapping("/find/{bookTitle}/{publicationYear}")
	public List<Book> findBookYear(@PathVariable String bookTitle , @PathVariable int publicationYear){
		return bookservice.findBookYears(bookTitle,publicationYear);
	}
	
	@GetMapping("/findTitle")
	public List<Book> findBookTitle(@RequestParam String bookTitle) {
	    return bookservice.findBookTitles(bookTitle);
	}
	
	@GetMapping("/fetch")
	public BookDto fetchBySizeNumber(@RequestParam("pageNumber") int pageNumber , @RequestParam("pageSize") int pageSize){
		return bookservice.fetchBySizeNumbers(pageNumber,pageSize);
	}
	
	@PutMapping("/update")
	public Book updateData(@RequestBody  @Valid Book books) {
		return bookservice.updateDatas(books);
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Book> deleteById(@PathVariable int id){
		return bookservice.deleteByIds(id);
	}
	
	
}
