package com.bootsample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@EnableAsync
@SecurityScheme(name = "bearerAuth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
@MapperScan(basePackages = "com.bootsample.mapper.**")
@EnableScheduling
@SpringBootApplication
public class BootSampleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSampleAppApplication.class, args);
	}
}
 