package com.quguang.springbootjwtdemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by quguang on 2018/6/23
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/restart")
    public String restart(){
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
