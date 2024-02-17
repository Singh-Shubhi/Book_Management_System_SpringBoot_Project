package com.bookmanagement.model;

import java.util.Date;
import java.util.Set;


import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.bookmanagement.customvalidation.PastPresentYearValidation;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@PastPresentYearValidation(message = " Publication year must not be in the future")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	@NotBlank(message="bookTitle should not be blank")
	private String bookTitle;
	
	@Column
	private int publicationYear;
	
	@Column
	@javax.validation.constraints.Min(value=500,message="Min price must be 500")
    private double price;

    @Column
    @NotBlank(message="edition should not be blank")
    private String edition;
    
    @Column
    @NotNull(message="pageCount should not be null")
    private int pageCount;

    @Column
    @Pattern(regexp = "\\d{3}-\\d{10}", message = "Invalid ISBN format")
    private String isbn;  
	
    @CreationTimestamp
	private Date createdDate;

	@UpdateTimestamp
	private Date updatedDate;
    
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "author_id")
	@Valid
	private Author author;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	@Valid
	private Category category;

	@OneToMany(cascade = CascadeType.ALL)
	@Valid
	private Set<Language> language;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Language> getLanguage() {
		return language;
	}

	public void setLanguage(Set<Language> language) {
		this.language = language;
	}

	public Book(int id, @NotBlank(message = "bookTitle should not be blank") String bookTitle, int publicationYear,
			@Min(value = 500, message = "Min price must be 500") double price,
			@NotBlank(message = "edition should not be blank") String edition,
			@NotNull(message = "pageCount should not be null") int pageCount,
			@Pattern(regexp = "\\d{3}-\\d{10}", message = "Invalid ISBN format") String isbn, Date createdDate,
			Date updatedDate, @Valid Author author, @Valid Category category, @Valid Set<Language> language) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.publicationYear = publicationYear;
		this.price = price;
		this.edition = edition;
		this.pageCount = pageCount;
		this.isbn = isbn;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.author = author;
		this.category = category;
		this.language = language;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}
