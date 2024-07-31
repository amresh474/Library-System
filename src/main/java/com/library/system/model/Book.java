package com.library.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "ISBN is mandatory")
	@Pattern(regexp = "\\d{13}", message = "ISBN should be 13 digits")
	private String isbn;

	@NotBlank(message = "Title is mandatory")
	private String title;

	@NotBlank(message = "Author is mandatory")
	private String author;

	public Book() {
	}

	public Book(Long id, String isbn, String title, String author) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + "]";
	}

}
