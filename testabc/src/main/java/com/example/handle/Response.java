package com.example.handle;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {
	
	private String status;
	private String error;
	private Date date=new Date();
}
