package com.example.testabc.user.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.testabc.user.model.Users;


@Service
public interface UserService  {

	List<Users> select();
	
	Users findByUsername(String username);
	
	Users insert(Users user);
	
	Users findByUsernameAndPassword(String username,String passowrd);
	
//	String findRoleByUsername(String username);
//	
	Iterable<Users> findRoleByUsername(String username);
}
