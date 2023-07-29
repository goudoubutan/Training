package com.csqf.zx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
//@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600)
@SpringBootApplication
@MapperScan("com.csqf.zx.mapper")
public class TrainingTest01Application {

    public static void main(String[] args) {
        SpringApplication.run(TrainingTest01Application.class, args);
    }

}
