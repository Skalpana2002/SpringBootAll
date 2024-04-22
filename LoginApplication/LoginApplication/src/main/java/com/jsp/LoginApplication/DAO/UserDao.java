package com.jsp.LoginApplication.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.LoginApplication.DTO.User;
import com.jsp.LoginApplication.REPOSITORY.LoginRepository;


@Repository

public class UserDao {
	@Autowired
	LoginRepository repository;
	// to insert user object
	public String saveUser(User user)
	{
		repository.save(user);
		return "User Registerd successfully.............";
		
	}
	
	
	//validating user for login
	public String loginValidation(String username , String password)
	{
		User u=repository.validateUser(username, password);
	       if(u!=null)
	       {
		      return "Login Successfully Done.............";
	        }
	
     return " Incorrect username and password";
	
	}
	
	

}
