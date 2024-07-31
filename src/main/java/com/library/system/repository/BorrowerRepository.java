package com.library.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.system.model.Borrower;

public interface BorrowerRepository extends JpaRepository<Borrower, Long> {

}
