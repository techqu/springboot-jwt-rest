package com.quguang.springbootjwtdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 瞿广 on 2018/10/13 0013.
 */
@Configuration
public class Swagger  {
    @Value("${swagger.show}")
    private boolean swaggerShow = false;
    private ParameterBuilder auth = new ParameterBuilder();
    private List<Parameter> list = new ArrayList<>();
//    {
//        auth.name("Authorization")
//                .description("用户登陆接口返回token")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header")
//                .required(false).build();
//        list.add(auth.build());
//    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(apiInfo("springboot-jwt-rest项目RestFul Api接口","权限管理接口", "0.1"))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.quguang.springbootjwtdemo.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(list)
                .groupName("权限管理接口");
    }


    public ApiInfo apiInfo(String title, String desc, String version ){
        return new ApiInfoBuilder()
                .title(title)
                .description(desc)
                .termsOfServiceUrl("http://localhost:8080")
                .version(version)
                .build();
    }
}
