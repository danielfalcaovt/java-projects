package com.springboot.sbe_02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboot")
public class Sbe02Application {

	public static void main(String[] args) {
		SpringApplication.run(Sbe02Application.class, args);
	}

}
