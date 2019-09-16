package com.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class CORSConfiguration implements WebMvcConfigurer {

    @Value("${project.upload.folderName}")
    private String folderName;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                //设置是否允许跨域传cookie
                .allowCredentials(true)
                //设置缓存时间，减少重复响应
                .maxAge(3600);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 检测文件目录是否存在
        String systemPath = System.getProperty("user.dir");
        File folder = new File(systemPath + "/" + folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        registry.addResourceHandler("/" + folderName + "/**").addResourceLocations("file:" + folder.getPath() + '/');
    }
}
