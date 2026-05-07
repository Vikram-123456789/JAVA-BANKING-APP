package org.jsp.Banking_app.controller;

import java.util.List;

import org.jsp.Banking_app.entity.User;
import org.jsp.Banking_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class UserController {
	@Autowired
	private UserService userSer;
	
	@PostMapping("/saveUser")
	public User createUser(@RequestBody User u) {
		return userSer.createUser(u);
	}
	
	@GetMapping("/getUserId")
	public User getUserByIdUser(@RequestParam long id) {
		return userSer.getUserById(id);
		}
	
	@DeleteMapping("delete")
	public String deleteUserById(@RequestParam long id) {
		return userSer.deleteUserById(id);
	}
	@GetMapping("searchByName")
	public List<User> searchUserByName(@RequestParam String name){
		return userSer.searchUserByName(name);
		
	}
	

}
