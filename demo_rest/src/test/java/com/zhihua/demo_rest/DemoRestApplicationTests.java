package com.zhihua.demo_rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRestApplicationTests {

	@Test
	public void contextLoads() {
	}




	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	/**
	 * get请求
	 */
	@Test
	public void getForObject() {
		String s = restTemplateBuilder.build().getForObject("http://localhost:8080/rest/update/{id}", String.class, 6);
		System.out.println(s);

		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", 7);
		String s1 = restTemplateBuilder.build().postForObject("http://localhost:8080/rest/update", map, String.class);
		System.out.println(s1);
	}

}
