package com.example.testabc.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.testabc.user.dao.UsersRepositorys;
import com.example.testabc.user.model.Users;

//import com.example.testabc.user.model.User;



@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsersRepositorys usersRepositorys;
	
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users=usersRepositorys.findByUsername(username);
		
		
		if(users==null) {
			throw new UsernameNotFoundException("使用者不存在");
		}

		System.out.println("users:  "+users);
		
        List<GrantedAuthority> auths =
                AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_test");
        //从查询数据库返回users对象，得到用户名和密码，返回
        
        System.out.println("user:  "+users.getUsername()+"password:  "+users.getPassword()
        +"auths:  "+auths);
        
        return new User(users.getUsername(),
                new BCryptPasswordEncoder().encode(users.getPassword()),auths);
    }
	


}
