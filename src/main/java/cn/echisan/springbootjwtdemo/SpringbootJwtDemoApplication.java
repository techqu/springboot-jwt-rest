package cn.echisan.springbootjwtdemo;

import cn.echisan.springbootjwtdemo.config.AppFilterInvocationSecurityMetadataSource;
import cn.echisan.springbootjwtdemo.config.ApplicationContext;
import cn.echisan.springbootjwtdemo.repository.BackendApiRepository;
import cn.echisan.springbootjwtdemo.repository.MenuRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

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
