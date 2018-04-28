package com.zhihua.demo_jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class DemoJmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJmsApplication.class, args);
	}
}
