package org.jsp.Banking_app.service;

import java.util.List;

import org.jsp.Banking_app.Exception.ResourceNotFoundException;
import org.jsp.Banking_app.entity.Loan;
import org.jsp.Banking_app.entity.User;
import org.jsp.Banking_app.repository.LoanRepository;
import org.jsp.Banking_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class LoanService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private LoanRepository loanRepo;
	
	
	public ResponseEntity<String> applyLoan(long userId,Loan loan) {
		User u=userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		u.addLoan(loan);
		loanRepo.save(loan);
		
		return new ResponseEntity<String>("loan applied",HttpStatus.CREATED);
		
	}
	
//	public String deleteLoan(Long userId, Long loanId) {
//		User u=userRepo.findById(userId).orElseThrow(()->new ResourcesNotFoundException("User", "User Id", userId));
//		
//		Loan l=loanRepo.findById(loanId).orElseThrow(()->new ResourcesNotFoundException("Loan", "Loan Id", loanId));
//		
//	}
	
	public ResponseEntity<String> deleteLoan(long userId,long loanId) {
		Loan l=loanRepo.findById(loanId).orElseThrow(()->new ResourceNotFoundException("Loan", "Loan Id", loanId));
		
		User u=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		
		u.removeLoan(l);
		loanRepo.delete(l);
		
		return new ResponseEntity<String>("data deleted",HttpStatus.OK);
		
		
	}
	
	public List<Loan> getLoanUserId(long userId){
		return loanRepo.findByUserUid(userId);
	}
	
	public String getLoanStatus(long id) {
		Loan l=loanRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Loan", "Loan Id", id));
		
		return l.getStatus();
	}

}
