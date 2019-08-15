package com.quguang.springbootjwtdemo.repository;


import com.quguang.springbootjwtdemo.entity.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
  * 企业数据访问接口
  */
public interface RoleDao extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {


    @EntityGraph(attributePaths = "permissions")
    @Override
    Optional<Role> findById(String username);
}