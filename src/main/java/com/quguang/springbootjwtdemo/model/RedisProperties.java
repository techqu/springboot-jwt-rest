package com.quguang.springbootjwtdemo.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by 瞿广 on 2018/11/17 0017.
 */
@Data
@Configuration
@Component
@ConfigurationProperties(prefix = "remote.service")
// PropertySource默认取application.properties
 @PropertySource(value = "redis.properties")
public class RedisProperties {
    private String host;
    private String port;
}
