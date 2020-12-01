package com.duing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.duing.dao")
@SpringBootApplication

public class ExamApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExamApplication.class, args);
    }

}
