package com.library.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.system.model.Book;
import com.library.system.model.Borrower;
import com.library.system.model.BorrowingRecord;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
	
	 boolean existsByBookAndReturnedFalse(Book book);

	Optional<BorrowingRecord> findByBorrowerAndBookAndReturnedFalse(Borrower borrower, Book book);
}
