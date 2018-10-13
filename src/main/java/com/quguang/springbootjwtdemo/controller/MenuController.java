package com.quguang.springbootjwtdemo.controller;

import com.quguang.springbootjwtdemo.entity.Menu;
import com.quguang.springbootjwtdemo.entity.User;
import com.quguang.springbootjwtdemo.repository.MenuRepository;
import com.quguang.springbootjwtdemo.repository.UserRepository;
import com.quguang.springbootjwtdemo.utils.JwtTokenUtils;
import com.quguang.springbootjwtdemo.utils.MenuTreeBuilder;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

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
@RequestMapping("/menus")
@Api(tags = "菜单管理")
public class MenuController {

    @Autowired
    MenuRepository menuRepository;
    @Autowired
    UserRepository userRepository;

    /**
     * 获取menu列表
     * @return
     */
    @GetMapping
    public  List getMenu( @RequestHeader HttpHeaders headers){
        JwtTokenUtils.getUserRole(headers.getFirst("Au"));
     List<Menu> menus =  menuRepository.findAll();
//     List<Menu> menuTree = MenuTreeBuilder.bulid(menus);
     List<Menu> menuTree = MenuTreeBuilder.buildByRecursive(menus);
     return menuTree;
    }

}
