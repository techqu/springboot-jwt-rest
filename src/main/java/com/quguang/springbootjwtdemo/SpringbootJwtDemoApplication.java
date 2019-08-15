package com.quguang.springbootjwtdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.quguang.springbootjwtdemo")
@EnableSwagger2
public class SpringbootJwtDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootJwtDemoApplication.class, args);



    }
}
