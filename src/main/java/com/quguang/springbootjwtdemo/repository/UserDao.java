package com.quguang.springbootjwtdemo.repository;

import com.quguang.springbootjwtdemo.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User> {


    @EntityGraph(attributePaths = "roles")
    User findByUsername(String username);


//    @EntityGraph(attributePaths = "roles")
//    List<User> findAll();

}
