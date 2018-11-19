package com.quguang.springbootjwtdemo.service;

import com.quguang.springbootjwtdemo.model.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 瞿广 on 2018/11/17 0017.
 */
@Service
public class TestService extends BaseServcie {

    @Autowired
    private RedisProperties properties;
    public TestService(){
        System.out.println("init TestService");


    }
    public void test(){
        System.out.println(this.port);
    }

}
