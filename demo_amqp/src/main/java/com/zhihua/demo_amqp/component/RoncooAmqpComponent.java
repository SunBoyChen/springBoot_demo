package com.zhihua.demo_amqp.component;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoncooAmqpComponent {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息
     * @param msg
     */
    public void send(String msg) {
        this.amqpTemplate.convertAndSend("roncoo.queue", msg);
    }

    /**
     * 监听消息
     * @param text
     */
    @RabbitListener(queues = "test.queue")
    public void receiveQueue(String text) {
        System.out.println("接受到：" + text);
    }

}
