package com.quguang.springbootjwtdemo.repository;

import com.quguang.springbootjwtdemo.entity.Role;
import com.quguang.springbootjwtdemo.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    @EntityGraph(attributePaths = "permissions")
    Role findById(String username);



}
