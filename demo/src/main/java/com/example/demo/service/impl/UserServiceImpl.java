package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.tx.UserServiceTx;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserServiceTx userServiceTx;

	@Override
	public User insert(User user) {
		
		User result=null;
		result=userServiceTx.create(user);
		return result;
	}




}
