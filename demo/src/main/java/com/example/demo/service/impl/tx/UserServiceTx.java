package com.example.demo.service.impl.tx;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;

@Service
public class UserServiceTx {

		@Autowired
		private UserRepository userRepository;
		@Transactional
		public User create(User user) {
			return userRepository.save(user);
		}
}
