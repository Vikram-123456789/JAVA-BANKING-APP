package org.jsp.Banking_app.entity;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
@Entity
public class User {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long uid;
	@NotBlank(message="name cannot be blank")
	private String name;
	@Email(message="Enter valid email")
	@Column(unique = true,nullable=false)
	private String email;
	@NotBlank(message="password cannot be blank")
	private String password;
	
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private Set<Loan> loans;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private Set<Account> accounts;
	
	
	
	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public void addLoan(Loan loan) {
		loans.add(loan);
		loan.setUser(this);
	}
	
	public void removeLoan(Loan l) {
		loans.remove(l);
		l.setUser(null);
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
		account.setUser(this);
	}
	
	public void removeAccount(Account a) {
		accounts.remove(a);
		a.setUser(null);
	}
	
	
	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
