package com.quguang.springbootjwtdemo.repository;


import com.quguang.springbootjwtdemo.entity.Permission;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 *  * 权限数据访问接口
 *  
 */
public interface PermissionDao extends JpaRepository<Permission, Integer>, JpaSpecificationExecutor<Permission> {

//    @EntityGraph(attributePaths = "roles")
    List<Permission> findByTypeAndPid(int type, String pid);

}