package com.library.system.service;

import com.library.system.model.BorrowingRecord;

public interface BorrowingRecordService {

	public BorrowingRecord borrowBook(Long borrowerId, Long bookId);

	public BorrowingRecord returnBook(Long borrowerId, Long bookId);

}
