package org.jsp.Banking_app.repository;

import java.util.List;

import org.jsp.Banking_app.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	public List<Loan> findByUserUid(long uid);

}
