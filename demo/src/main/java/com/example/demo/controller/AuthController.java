package com.example.demo.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.JwtUser;
import com.example.demo.model.User;
import com.example.demo.model.Users;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtTokenUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by echisan on 2018/6/23
 */
@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    
    @Autowired
    private UserService userService;

    
    @PostMapping("/register/username/{username}/password/{password}")
    public ResponseEntity<Users> registerUser(@PathVariable String username,@PathVariable String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        user.setRole("ROLE_USER");
        User save = userService.insert(user);
        
        String token=jwtTokenUtils.createToken(username, "ROLE_USER", true);
        

        
        Users users=new Users();
        users.setId(user.getId());
        users.setUsername(user.getUsername());
        users.setPassword(user.getPassword());
        users.setRole(user.getRole());
        users.setToken(token);
        
        
        //token 測試
        ResponseEntity<Users> result=null;
        result=ResponseEntity.ok().body(users);

        
        return result;
    }
    
    

}
