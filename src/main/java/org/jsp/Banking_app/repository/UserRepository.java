package org.jsp.Banking_app.repository;

import java.util.List;

import org.jsp.Banking_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	List<User>findByName(String name);
	

}
