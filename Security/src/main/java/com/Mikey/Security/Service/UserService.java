package com.Mikey.Security.Service;

import com.Mikey.Security.Model.User;
import com.Mikey.Security.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encode= new BCryptPasswordEncoder(12);

    public User addUser(@RequestBody User user){
        user.setPassword(encode.encode(user.getPassword()));
        return repo.save(user);
    }

    public List<User> listUsers() {
        return repo.findAll();
    }


}
