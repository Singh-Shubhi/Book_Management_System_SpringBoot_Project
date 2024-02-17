package com.bookmanagement.model;

import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	@NotBlank(message="authorName should not be blank")
	private String authorName;
	
	@Column
	@NotBlank(message="authorSurname should not be blank")
	private String authorSurname;
	
	@Column
	@Min(value = 0, message = "age should not be empty")
	private int age;
	
	@OneToMany(mappedBy = "author")
	@JsonIgnore
	private Set<Book> books;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public String getAuthorSurname() {
		return authorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Author(int id, @NotBlank(message = "authorName should not be blank") String authorName,
			@NotBlank(message = "authorSurname should not be blank") String authorSurname,
			@Min(value = 0, message = "age should not be empty") int age, Set<Book> books) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.authorSurname = authorSurname;
		this.age = age;
		this.books = books;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}