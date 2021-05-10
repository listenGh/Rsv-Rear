package com.gh.rsv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.gh.rsv.Dao")
@SpringBootApplication
public class RsvApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsvApplication.class, args);
    }

}
