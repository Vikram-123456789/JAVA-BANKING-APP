package org.jsp.Banking_app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.jsp.Banking_app.Exception.ResourceNotFoundException;
import org.jsp.Banking_app.entity.Account;
import org.jsp.Banking_app.entity.Transaction;
import org.jsp.Banking_app.repository.AccountRepository;
import org.jsp.Banking_app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository tranRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	public ResponseEntity<String> addTransaction(long accountId,Transaction transaction){
		Account account = accountRepo.findById(accountId)
					.orElseThrow(() -> new ResourceNotFoundException("Account", "AccountId", accountId));
		    account.addTransaction(transaction);
			accountRepo.save(account);
			return new ResponseEntity<>("transaction added", HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<Transaction>> getAllTransactionByUser(long userId, int pageNo, int pageSize) {
		Sort sort = Sort.by("date").ascending();
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
		List<Transaction> transactions = tranRepo.findByAccountUserUid(userId, pageable);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

	public ResponseEntity<List<Transaction>> getUsertransactionByAmount(long userId, Double st, Double end) {
		List<Transaction> transactions = tranRepo.getUsertransactionByAmount(userId, st, end);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

	public ResponseEntity<List<Transaction>> getUsertransactionByDate(long userId, LocalDateTime st, LocalDateTime end) {
		List<Transaction> transactions = tranRepo.getUsertransactionDate(userId, st, end);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}



	

}
