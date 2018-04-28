package com.zhihua.demo_jms;

import com.zhihua.demo_jms.component.RoncooJmsComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoJmsApplicationTests {

	@Autowired
	private RoncooJmsComponent roncooJmsComponent;

	@Test
	public void send() {
		roncooJmsComponent.send("hello world");
	}

	@Test
	public void send2() throws InterruptedException {
		HashMap map = new HashMap();
		map.put("name","zhihua");
		map.put("test",6666);
		Thread.sleep(3000);
		roncooJmsComponent.sendTopic(map);
	}


}
