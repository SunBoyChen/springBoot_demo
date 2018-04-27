package com.zhihua.demo_mongodb;

import com.zhihua.demo_mongodb.component.RoncooMongodbComponent;
import com.zhihua.demo_mongodb.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoMongodbApplicationTests {
	@Resource
	private RoncooMongodbComponent component;

	@Test
	public void contextLoads() {
		component.save();

		UserEntity userEntity = component.selectById(1L);
		System.out.println(userEntity);
	}

}
