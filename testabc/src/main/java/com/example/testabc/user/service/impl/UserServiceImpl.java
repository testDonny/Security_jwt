package com.example.testabc.user.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.testabc.user.dao.UsersRepositorys;
import com.example.testabc.user.model.Users;
import com.example.testabc.user.service.UserService;




@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UsersRepositorys userRepositorys ;

	
	/**
	 * 查詢資料
	 */
	@Override
	public List<Users> select() {
		return userRepositorys.findAll();
	}

	@Override
	public Users insert(Users user) {

		return userRepositorys.saveAndFlush(user);
	}

	@Override
	public Users findByUsernameAndPassword(String username, String passowrd) {

		return userRepositorys.findByUsernameAndPassword(username, passowrd);
	}

	@Override
	public Users findByUsername(String username) {
	
		return userRepositorys.findByUsername(username);
	}

	@Override
	public Iterable<Users> findRoleByUsername(String username) {
		return userRepositorys.findRoleByUsername(username);
	}



}
