package org.jsp.Banking_app.service;

import java.util.List;

import org.jsp.Banking_app.Exception.ResourceNotFoundException;
import org.jsp.Banking_app.entity.Account;
import org.jsp.Banking_app.entity.User;
import org.jsp.Banking_app.repository.AccountRepository;
import org.jsp.Banking_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class AccountService {
	@Autowired
	private AccountRepository accRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	
	public ResponseEntity<String> createAccount(long userId,Account account){
		User u=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId", userId));
		
		
		u.addAccount(account);
	    userRepo.save(u);
	    
	    return new ResponseEntity<String>("account created",HttpStatus.OK);
	}
	
	public ResponseEntity<Account> getAccountById(long id){
		Account a=accRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Account", "Account id", id));
		
		return new ResponseEntity<Account>(a,HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteAccountById(long userId, long accountId){
		User u=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "userId", userId));
		
		Account a=accRepo.findById(accountId).orElseThrow(()->new ResourceNotFoundException("Account", "AccountId", accountId));
		
		
		u.removeAccount(a);
		accRepo.delete(a);
		return new ResponseEntity<String>("Account deleted",HttpStatus.OK);
		
	}
	
	public ResponseEntity<List<Account>> getAccountByUserId(long userId){
		List<Account> accounts=accRepo.getAccountByUserId(userId);
		return new ResponseEntity<List<Account>>(accounts,HttpStatus.OK);
	}
	
	public ResponseEntity<Double> getBalance(long id){
		Account a=accRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Account", "ID =", id));
		
		return new ResponseEntity<Double>(a.getBalance(),HttpStatus.OK);
	}

}
