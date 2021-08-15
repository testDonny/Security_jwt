package com.example.demo.model;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Users {

	
    private Integer id;


    private String username;


    private String password;


    private String role;
    
    private String Token;
}
