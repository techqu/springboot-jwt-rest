package com.quguang.springbootjwtdemo.repository;

import com.quguang.springbootjwtdemo.Tester;
import com.quguang.springbootjwtdemo.entity.Role;
import com.quguang.springbootjwtdemo.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class UserRepositoryTest extends Tester {

    @Autowired
    UserRepository userRepository;
    @Test
    public void findByUsername() throws Exception {
       User user =  userRepository.findByUsername("admin");

        List<String> list = new ArrayList<>();
        user.getRoles().stream().forEach(r -> list.add(r.getName()));


        System.out.println(StringUtils.collectionToCommaDelimitedString(list));
    }

}