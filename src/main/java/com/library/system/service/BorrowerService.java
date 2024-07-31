package com.library.system.service;

import java.util.List;

import com.library.system.exception.BorrowerRegistrationException;
import com.library.system.exception.BorrowerRetrivalException;
import com.library.system.model.Borrower;

public interface BorrowerService {

	public Borrower registerBorrower(Borrower borrower) throws BorrowerRegistrationException;

	public List<Borrower> getAllBorrowers() throws BorrowerRetrivalException;

}
