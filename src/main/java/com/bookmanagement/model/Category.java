package com.bookmanagement.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	@NotBlank(message="CategoryName should not be blank")
	private String categoryName;
	
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private Set<Book> books;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Category(int id, @NotBlank(message = "CategoryName should not be blank") String categoryName,
			Set<Book> books) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.books = books;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}