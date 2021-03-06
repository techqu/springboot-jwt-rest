package com.quguang.springbootjwtdemo.controller;

import com.quguang.springbootjwtdemo.entity.Role;
import com.quguang.springbootjwtdemo.dto.req.RoleBackendApiReq;
import com.quguang.springbootjwtdemo.dto.req.RoleMenuReq;
import com.quguang.springbootjwtdemo.repository.RoleRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by quguang on 2018/6/23
 *
 * 用户管理
 *  新增用户、修改用户、注销账户、给用户分配角色
 * 角色管理
 *  新增角色、修改角色、给角色配置菜单和api权限
 * 菜单管理
 *  新增菜单、修改菜单
 * 后端api管理
 *  新增api、修改api、删除api
 */
@RestController
@RequestMapping("/roles")
@Api(tags = "role manager")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;


    @ApiOperation(value = "save role")
    @PostMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Role addRole(@RequestBody Role role){
       Role roleS  =  roleRepository.save(role);
        return roleS;
    }
    @PostMapping(value = "menus",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addRoleMenus(@RequestBody RoleMenuReq roleMenuReq){
        return null;
    }

    @PostMapping(value = "backendApi",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addRoleApi(@RequestBody RoleBackendApiReq roleBackendApiReq){
        return null;
    }

}
