package com.library.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BorrowingRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "borrower_id")
	private Borrower borrower;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	private boolean returned;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Borrower getBorrower() {
		return borrower;
	}

	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public boolean isReturned() {
		return returned;
	}

	public void setReturned(boolean returned) {
		this.returned = returned;
	}

}
