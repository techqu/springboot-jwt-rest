package com.quguang.springbootjwtdemo.controller;

import com.quguang.springbootjwtdemo.common.ResultResponse;
import com.quguang.springbootjwtdemo.dto.TestDto;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

/**
 * Created by quguang on 2018/6/23
 */
@RestController
@RequestMapping("/test")
@Validated
public class TestController {


    @GetMapping(value = "/aa",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test(@RequestParam @Max(10) String name) {

        TestDto test = TestDto.builder()
                .name(name)
                .age(90)
                .build();

        return ResultResponse.createResultResponse().toJson();
    }

    @GetMapping("/health")
    public String health() {
        return "health";
    }

    @GetMapping("/demo")
    public String demo() {
        return "demo";
    }


    @GetMapping("/ignore")
    public String ignore() {
        return "ignore";
    }


    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String newTasks() {
        return "创建了一个新的任务";
    }


}
