package org.jsp.Banking_app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.jsp.Banking_app.entity.Transaction;
import org.jsp.Banking_app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	  @Autowired
	    private TransactionService transactionService;

	    // Add a transaction to an account
	    @PostMapping("/account/{accountId}")
	    public ResponseEntity<String> addTransaction(
	            @PathVariable long accountId,
	            @RequestBody Transaction transaction) {

	        return transactionService.addTransaction(accountId, transaction);
	    }

	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Transaction>> getAllTransactionsByUser(
	            @PathVariable long userId,
	            @RequestParam int pageNo,
	            @RequestParam int pageSize) {

	        return transactionService.getAllTransactionByUser(userId, pageNo, pageSize);
	    }

	    @GetMapping("/user/{userId}/amount")
	    public ResponseEntity<List<Transaction>> getTransactionsByAmount(
	            @PathVariable long userId,
	            @RequestParam Double start,
	            @RequestParam Double end) {

	        return transactionService.getUsertransactionByAmount(userId, start, end);
	    }

	    @GetMapping("/user/{userId}/date")
	    public ResponseEntity<List<Transaction>> getTransactionsByDate(
	            @PathVariable long userId,
	            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
	            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {

	        return transactionService.getUsertransactionByDate(userId, start, end);
	    }

}
