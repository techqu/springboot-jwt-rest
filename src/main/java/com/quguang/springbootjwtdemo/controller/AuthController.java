package com.quguang.springbootjwtdemo.controller;

import com.quguang.springbootjwtdemo.entity.Role;
import com.quguang.springbootjwtdemo.entity.User;
import com.quguang.springbootjwtdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by quguang on 2018/6/23
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        User user = new User();
        user.setUsername(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setName("ROLE_NORMAL");
        role.setRemark("普通用户");
        roles.add(role);
        user.setRoles(roles);
        User save = userRepository.save(user);
        return save.toString();
    }
}
