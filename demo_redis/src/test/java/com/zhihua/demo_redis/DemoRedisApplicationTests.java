package com.zhihua.demo_redis;

import com.zhihua.demo_redis.Component.RedisComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRedisApplicationTests {

	@Resource
	private RedisComponent redisComponent;

	@Test
	public void contextLoads() {
		redisComponent.set("name","123");
        //redisComponent.del("name");
        String name = redisComponent.get("name");

        System.out.println(name);
    }

}
