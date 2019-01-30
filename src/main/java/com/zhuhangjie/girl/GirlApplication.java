package com.zhuhangjie.girl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GirlApplication {

    /**
     * 在使用java -jar启动时 可以在最后添加--spring.profiles.active=prod来选择环境
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }

}

