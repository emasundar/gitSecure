package com.Mikey.Security.Controller;

import com.Mikey.Security.Model.User;
import com.Mikey.Security.Service.JwtService;
import com.Mikey.Security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtservice;

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User createdUser  = service.addUser (user);
        return new ResponseEntity<>(createdUser , HttpStatus.CREATED);
    }

    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.listUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @PostMapping("login")
    public String login(@RequestBody User user){

        Authentication authentication=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtservice.generateToken(user.getUsername());
        else
            return "fail";
    }
}