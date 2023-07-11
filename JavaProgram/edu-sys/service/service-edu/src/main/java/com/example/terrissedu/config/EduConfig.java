package com.example.terrissedu.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Terriss
 * @time 2023-06-28 09:04:05
 * @description TODO
 */
@Configuration
@MapperScan("com.example.com.example.terrissedu.mapper")
public class EduConfig {

    // 逻辑删除配置
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
}
