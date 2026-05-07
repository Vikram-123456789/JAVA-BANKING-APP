package org.jsp.Banking_app.controller;

import java.util.List;

import org.jsp.Banking_app.entity.Loan;
import org.jsp.Banking_app.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/loans")
public class LoanController {
	@Autowired
	private LoanService loanSer;
	
	@PostMapping("/apply{userId}")
	public ResponseEntity<String> applyLoan(@PathVariable long userId,@RequestBody Loan loan) {
		return loanSer.applyLoan(userId, loan);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteLoan(@RequestParam long userId,@RequestParam long loanId){
		return loanSer.deleteLoan(userId, loanId);
	}
	
	@GetMapping("/getLoan/{userId}")
	public List<Loan> getLoanUserId(@PathVariable long userId){
		return loanSer.getLoanUserId(userId);
	}
	
	@GetMapping("/getStatus/{loanId}")
	public String getLoanStatus(@PathVariable  long loanId) {
		return  loanSer.getLoanStatus(loanId);
	}

}
