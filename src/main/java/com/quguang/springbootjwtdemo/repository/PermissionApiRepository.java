package com.quguang.springbootjwtdemo.repository;

import com.quguang.springbootjwtdemo.entity.PermissionApi;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionApiRepository extends JpaRepository<PermissionApi, Integer> {


    PermissionApi findByPathAndMethod(String path, String method);


    List<PermissionApi> findByPathStartsWithAndMethod(String path, String method);


}
