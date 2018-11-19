package com.quguang.springbootjwtdemo.controller;

import com.quguang.springbootjwtdemo.model.RedisProperties;
import com.quguang.springbootjwtdemo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by quguang on 2018/6/23
 */
@RestController
@RequestMapping("/test")
public class TestController {

  @Resource
  private TestService testService;

    @GetMapping("/restart")
    public String restart(){

      testService.test();

        return "restart";
    }

    @GetMapping("/health")
    public String health(){
        return "health";
    }

    @GetMapping("/demo")
    public String demo(){
        return "demo";
    }


    @GetMapping("/ignore")
    public String ignore(){
        return "ignore";
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String newTasks(){
        return "创建了一个新的任务";
    }


}
