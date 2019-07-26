package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ldl
 * @Date: 2019/7/19 9:34
 */
@Configuration
public class DBconfig {
    @Bean
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }
}
