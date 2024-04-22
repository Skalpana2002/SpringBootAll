package com.jsp.LoginApplication.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.LoginApplication.DTO.User;

public interface LoginRepository extends JpaRepository<User, Integer>
{
	
	@Query("select u from User u where u.username=?1 and u.password=?2")
	public User validateUser(String username , String password);

}
