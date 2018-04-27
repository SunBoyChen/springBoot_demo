package com.hihua.demo_web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class DemoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
	}

	/*
	注册bean
	//注册bean
	@Bean
	public ServletRegistrationBean servletRegistrationBean(){
		return new ServletRegistrationBean(new CustomerServlet(),"/test");
	}

	//注册filter
	@Bean
	public FilterRegistrationBean filterRegistrationBean(){
		return  new FilterRegistrationBean(new CustomFilter(),servletRegistrationBean());
	}

	//注册
	@Bean
	public ServletListenerRegistrationBean servletListenerRegistrationBean(){
		return new ServletListenerRegistrationBean(new CustomListener());
	}*/
}
