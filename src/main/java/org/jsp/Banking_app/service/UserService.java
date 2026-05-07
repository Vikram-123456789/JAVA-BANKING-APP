package org.jsp.Banking_app.service;

import java.util.List;

import org.jsp.Banking_app.Exception.ResourceNotFoundException;
import org.jsp.Banking_app.entity.User;
import org.jsp.Banking_app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User getUserById(long id) {
		return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
		
	}
	
	public User createUser(User u) {
		return userRepo.save(u);
	}
	
	public String deleteUserById(long id) {
		User u=userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
		
		userRepo.deleteById(id);
		
		return "data deleted";
	}
	
	public List<User> searchUserByName(String name){
		return userRepo.findByName(name);
	}


	

}
