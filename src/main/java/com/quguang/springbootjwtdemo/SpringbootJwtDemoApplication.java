package com.quguang.springbootjwtdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class SpringbootJwtDemoApplication {

    static ConfigurableApplicationContext applicationContext;



//    public static void postInit(){
//        ApplicationContext
//                .getBean(AppFilterInvocationSecurityMetadataSource.class)
//                .init(applicationContext.getBean(MenuRepository.class),applicationContext.getBean(BackendApiRepository.class));
//    }



    public static void main(String[] args) {
        SpringApplication.run(SpringbootJwtDemoApplication.class, args);


        // 后初始化
//        postInit();

    }
}
