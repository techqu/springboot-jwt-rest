package com.quguang.springbootjwtdemo.repository;

import com.quguang.springbootjwtdemo.entity.PermissionMenu;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MenuRepository extends JpaRepository<PermissionMenu, Integer> {

    @EntityGraph(attributePaths = "roles")
    PermissionMenu findOneWithRolesById(long id);

}
