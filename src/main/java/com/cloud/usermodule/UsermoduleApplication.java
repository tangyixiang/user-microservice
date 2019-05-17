package com.cloud.usermodule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.cloud.usermodule.user.dao")
@EnableCaching
public class UsermoduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsermoduleApplication.class, args);
    }

}
