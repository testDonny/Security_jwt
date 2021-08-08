package com.example.testabc.user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testabc.user.model.Users;


@Repository
public interface UsersRepositorys extends JpaRepository<Users,String>{

	Users findByUsernameAndPassword(String username,String passowrd);
	
	Users findByUsername(String username);
	
	Iterable<Users> findRoleByUsername(String username);

}
