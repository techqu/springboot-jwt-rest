package com.quguang.springbootjwtdemo.repository;

import com.quguang.springbootjwtdemo.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    @EntityGraph(attributePaths = "roles")
    User findByUsername(String username);

}
