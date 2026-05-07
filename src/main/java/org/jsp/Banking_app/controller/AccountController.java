package org.jsp.Banking_app.controller;

import java.util.List;

import org.jsp.Banking_app.entity.Account;
import org.jsp.Banking_app.service.AccountService;
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
@RequestMapping("/api/account")
public class AccountController {
	@Autowired
	private AccountService accountSer;
	
	@PostMapping("/createAccount/{userId}")
	public ResponseEntity<String> createAccount(@PathVariable long userId,@RequestBody Account account){
		return accountSer.createAccount(userId, account);
	}
	@GetMapping("/getAccountId")
	public ResponseEntity<Account> getAccountById(@RequestParam long id){
		return accountSer.getAccountById(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAccountById(@RequestParam long userId,@RequestParam long accountId){
		return accountSer.deleteAccountById(userId, accountId);
	}
	
	@GetMapping("/getAccountUser/{userId}")
	public ResponseEntity<List<Account>> getAccountByUserId(@PathVariable long userId){
		return accountSer.getAccountByUserId(userId);
	}
	
	@GetMapping("/getBalance/{id}")
	public ResponseEntity<Double> getBalance(@PathVariable long id){
		return accountSer.getBalance(id);
		
	}
	

}
