package com.zhihua.demo_amqp;

import com.zhihua.demo_amqp.component.CallBackSender;
import com.zhihua.demo_amqp.component.RoncooAmqpComponent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoAmqpApplicationTests {

	@Autowired
	private RoncooAmqpComponent roncooAmqpComponent;

	@Test
	public void send() {
		roncooAmqpComponent.send("hello world2");
	}

	@Test
	public void sendUser() {
		roncooAmqpComponent.sendUser();
	}

	@Test
	public void send2() {
		roncooAmqpComponent.send();
	}

	@Test
	public void sendFanout() {
		roncooAmqpComponent.sendFanout();
	}


	@Autowired
	private CallBackSender callBackSender;

	@Test
	public void callBack() {
		callBackSender.send();
	}

}
