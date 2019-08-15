package com.quguang.springbootjwtdemo.controller;

import com.quguang.springbootjwtdemo.entity.User;
import com.quguang.springbootjwtdemo.dto.req.UserRoleReq;
import com.quguang.springbootjwtdemo.repository.UserRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
@RequestMapping("/users")
@Api(tags = "用户管理")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @ApiOperation(value = "根据用户的username获取角色",notes = "返回的角色是一个列表")

    @ApiImplicitParams({
            @ApiImplicitParam(name="userName",value="用户名",required=true,paramType="string",dataType="string")
    })
    @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
    })
    @GetMapping(value = "roles" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List getUserRole(@RequestParam String userName){
        return new ArrayList(userRepository.findByUsername(userName).getRoles());
    }

    @PostMapping(value = "role",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String addRoleMenus(@RequestBody UserRoleReq userRoleReq){
        return null;
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser(@PathVariable("id")  Integer id){
       Optional<User> user =  userRepository.findById(id);
        return user.get();
    }

    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List getUsers(){
        List<User> users =  userRepository.findAll();
        return users;
    }

}
