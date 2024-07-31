package com.library.system.serviceImpl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.library.system.exception.BookRegistrationException;
import com.library.system.exception.BookRetrievalException;
import com.library.system.exception.BorrowerRegistrationException;
import com.library.system.exception.BorrowerRetrivalException;
import com.library.system.model.Book;
import com.library.system.model.Borrower;
import com.library.system.repository.BorrowerRepository;
import com.library.system.service.BorrowerService;

@Service
public class BorrowerServiceImpl implements BorrowerService {

	@Autowired
	private BorrowerRepository borrowerRepository;

	@Override
	public Borrower registerBorrower(Borrower borrower) throws BorrowerRegistrationException {
		try {
			return borrowerRepository.save(borrower);

		} catch (DataAccessException e) {
			throw new BorrowerRegistrationException("Failed to register book.", e);
		} catch (Exception e) {
			throw new BorrowerRegistrationException(e.getMessage(), e);
		}

	}

	@Override
	public List<Borrower> getAllBorrowers() throws BorrowerRetrivalException {
		try {
			List<Borrower> borrowers = borrowerRepository.findAll();
			return borrowers != null ? borrowers : Collections.emptyList();
		} catch (DataAccessException e) {
			throw new BorrowerRetrivalException("Failed to retrieve books.", e);
		} catch (Exception e) {
			throw new BorrowerRetrivalException(e.getMessage(), e);
		}

	}

}
