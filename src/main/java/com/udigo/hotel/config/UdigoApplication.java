package com.udigo.hotel.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.udigo.hotel")
@MapperScan(basePackages = "com.udigo.hotel", annotationClass = Mapper.class )
public class UdigoApplication {

    public static void main(String[] args) {

        SpringApplication.run(UdigoApplication.class, args);
    }

}
