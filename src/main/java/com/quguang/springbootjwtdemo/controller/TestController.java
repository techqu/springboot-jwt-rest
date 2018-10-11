package com.quguang.springbootjwtdemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Created by quguang on 2018/6/23
 */
@RestController
@RequestMapping("/")
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



    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String newTasks(){
        return "创建了一个新的任务";
    }

    @PutMapping("/{taskId}")
    public String updateTasks(@PathVariable("taskId")Integer id){
        return "更新了一下id为:"+id+"的任务";
    }

    @DeleteMapping("/{taskId}")
    public String deleteTasks(@PathVariable("taskId")Integer id){
        return "删除了id为:"+id+"的任务";
    }
}
