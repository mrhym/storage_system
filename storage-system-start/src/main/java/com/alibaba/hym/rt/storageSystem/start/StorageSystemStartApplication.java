package com.alibaba.hym.rt.storageSystem.start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ServletComponentScan
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = "com.alibaba.hym.rt.storageSystem.*")
@PropertySource(value = "application.properties")
//@ImportResource(locations = {"classpath*:spring/spring-*.xml"})
@MapperScan("com.alibaba.hym.rt.storageSystem.service.dao")
public class StorageSystemStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageSystemStartApplication.class, args);
    }

}
