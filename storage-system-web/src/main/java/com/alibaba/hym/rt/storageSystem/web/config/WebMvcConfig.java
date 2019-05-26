package com.alibaba.hym.rt.storageSystem.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author MonkeyKing
 * @Description: TODO
 * @Date: 2019/3/15 17:36
 **/

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Value("${file.save.basePath}")
    private String basePath;

    @Value("${file.save.sonPath}")
    private String sonPath;

    private final String pathHeader = "file:";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        StringBuilder path = new StringBuilder();
        path.append(pathHeader)
                .append(basePath)
                .append(sonPath);
        registry.addResourceHandler("/img/**").addResourceLocations(path.toString());
        super.addResourceHandlers(registry);
    }
}