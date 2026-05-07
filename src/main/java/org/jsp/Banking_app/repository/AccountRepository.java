package org.jsp.Banking_app.repository;

import java.util.List;

import org.jsp.Banking_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	@Query(value="select a from Account a where a.user.uid=?1")
	List<Account> getAccountByUserId(long userId);

}
