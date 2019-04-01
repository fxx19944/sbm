package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class TestApplication {

	public static void main(String[] args) {
		//System.setProperty("spring.config.location","classpath:application.properties");
		SpringApplication.run(TestApplication.class, args);
		System.out.println("启动成功");
	}
}
