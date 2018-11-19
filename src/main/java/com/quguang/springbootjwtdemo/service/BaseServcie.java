package com.quguang.springbootjwtdemo.service;

import com.quguang.springbootjwtdemo.model.RedisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


/**
 * Created by 瞿广 on 2018/11/17 0017.
 */
//@ConfigurationProperties(prefix = "remote.service")
// PropertySource默认取application.properties
@PropertySource(value = "redis.properties")
public class BaseServcie {


    @Value("${remote.service.host}")
     protected  String host ;

    @Value("${remote.service.port}")
     protected  String port;

    BaseServcie(){
        System.out.println("init baseService");
//       this.host =  properties.getHost();
//       this.port = properties.getPort();
    }

}
