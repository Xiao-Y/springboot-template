package com.billow;

import com.billow.mybatis.tools.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan("com.billow.*.dao")
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringContextUtil.setApplicationContext(SpringApplication.run(App.class, args));
    }
}
