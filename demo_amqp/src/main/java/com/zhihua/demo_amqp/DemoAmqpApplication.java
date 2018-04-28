package com.zhihua.demo_amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableRabbit
@SpringBootApplication
public class DemoAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoAmqpApplication.class, args);
	}
}
