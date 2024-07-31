package com.library.system.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.library.system.exception.BookRegistrationException;
import com.library.system.exception.BorrowingException;
import com.library.system.exception.RecordNotFoundException;
import com.library.system.model.Book;
import com.library.system.model.Borrower;
import com.library.system.model.BorrowingRecord;
import com.library.system.repository.BookRepository;
import com.library.system.repository.BorrowerRepository;
import com.library.system.repository.BorrowingRecordRepository;
import com.library.system.service.BorrowingRecordService;

import jakarta.transaction.Transactional;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

	@Autowired
	private BorrowingRecordRepository borrowingRecordRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BorrowerRepository borrowerRepository;

	@Transactional
	@Override
	public BorrowingRecord borrowBook(Long borrowerId, Long bookId) throws BorrowingException {

		try {
			Optional<Borrower> borrower = borrowerRepository.findById(borrowerId);
			Optional<Book> book = bookRepository.findById(bookId);

			if (borrower.isEmpty() || book.isEmpty()) {
				throw new BorrowingException("Invalid borrower or book ID");
			}

			if (borrowingRecordRepository.existsByBookAndReturnedFalse(book.get())) {
				throw new BorrowingException("Book is already borrowed");
			}

			BorrowingRecord borrowingRecord = new BorrowingRecord();
			borrowingRecord.setBorrower(borrower.get());
			borrowingRecord.setBook(book.get());
			borrowingRecord.setReturned(false);

			return borrowingRecordRepository.save(borrowingRecord);
		} catch (DataAccessException e) {
			throw new BorrowingException("Failed to register book.", e);
		} catch (Exception e) {
			throw new BorrowingException(e.getMessage(), e);
		}
	}

	@Override
	public BorrowingRecord returnBook(Long borrowerId, Long bookId) {

		try {
			Optional<Borrower> borrower = borrowerRepository.findById(borrowerId);
			Optional<Book> book = bookRepository.findById(bookId);

			if (borrower.isEmpty() || book.isEmpty()) {
				throw new BorrowingException("Invalid borrower or book ID");
			}

			BorrowingRecord borrowingRecord = borrowingRecordRepository
					.findByBorrowerAndBookAndReturnedFalse(borrower.get(), book.get())
					.orElseThrow(() -> new RecordNotFoundException(
							"No borrowing record found for the given borrower and book"));
			borrowingRecord.setReturned(true);
			return borrowingRecordRepository.save(borrowingRecord);
		} catch (DataAccessException e) {
			throw new BorrowingException("Failed to register book.", e);
		} catch (Exception e) {
			throw new BorrowingException(e.getMessage(), e);
		}

	}

}
