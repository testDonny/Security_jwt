package com.example.testabc.user.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author user1
 *
 */
@Entity
@Table(name = "User", indexes = { @Index(name = "username", columnList = "username", unique = true)})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Users implements Serializable{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "id", unique = true)
	private String id;
	@Column(length=30)
	private String username;
	@Column(length=30)
	private String password;
	@Column(length=30)
	private String role;


	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		builder.appendSuper(super.toString());
		builder.append("id", id);
		builder.append("userName",username);
		builder.append("passwor",password);
		builder.append("role",role);


		return builder.toString();
	}



}
