package com.library.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.system.model.Borrower;
import com.library.system.service.BorrowerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/borrowers")
public class BorrowerController {

	@Autowired
	private BorrowerService borrowerService;

	@PostMapping
	public ResponseEntity<?> registerBorrower(@Valid @RequestBody Borrower borrower) {
		Borrower registeredBorrower = null;

		registeredBorrower = borrowerService.registerBorrower(borrower);

		if (registeredBorrower == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Borrower registration failed");
		}

		return ResponseEntity.ok(registeredBorrower);
	}

	@GetMapping
	public ResponseEntity<?> getAllBorrowers() {
		List<Borrower> borrowers = null;

		borrowers = borrowerService.getAllBorrowers();

		if (borrowers == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve borrowers.");
		}
		if (borrowers.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books found.");
		}

		return ResponseEntity.ok(borrowers);
	}

}
