package com.library.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.system.exception.BorrowingException;
import com.library.system.model.BorrowingRecord;
import com.library.system.service.BorrowingRecordService;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingRecordController {

	@Autowired
	private BorrowingRecordService borrowingRecordService;

	@PostMapping("/borrow")
	public ResponseEntity<?> borrowBook(@RequestParam Long borrowerId, @RequestParam Long bookId) {
		BorrowingRecord borrowingRecord = null;

		borrowingRecord = borrowingRecordService.borrowBook(borrowerId, bookId);
		if (borrowingRecord == null) {
			throw new BorrowingException("BorrowBook registration failed");
		}

		return ResponseEntity.ok(borrowingRecord);
	}

	@PostMapping("/return")
	public ResponseEntity<BorrowingRecord> returnBook(@RequestParam Long borrowerId, @RequestParam Long bookId) {
		BorrowingRecord borrowingRecord = null;
		borrowingRecord = borrowingRecordService.returnBook(borrowerId, bookId);
		if (borrowingRecord == null) {
			throw new BorrowingException("BorrowBook registration failed");
		}
		return ResponseEntity.ok(borrowingRecord);
	}

}
