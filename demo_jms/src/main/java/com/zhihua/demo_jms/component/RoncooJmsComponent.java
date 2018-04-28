package com.zhihua.demo_jms.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Map;

@Component
public class RoncooJmsComponent {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    //发送
    public void send(String msg) {
        System.out.println("发送");
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    //监听
    @JmsListener(destination = "test.queue")
    public void receiveQueue(String text) {
        System.out.println("接受到1：" + text);
    }

    //监听
    @JmsListener(destination = "test.queue")
    public void receive2Queue(String text) {
        System.out.println("接受到2：" + text);
    }


    //发送
    public void sendTopic(Map map) {
        System.out.println("发送");
        this.jmsMessagingTemplate.convertAndSend(this.topic, map);
    }


    //监听
    @JmsListener(destination = "test.topic")
    public void receiveTopic(Map map) {
        System.out.println("接受到2：" + map);
    }


    //监听
    @JmsListener(destination = "test.topic")
    public void receiveTopic2(Map map) {
        System.out.println("接受到2：" + map);
    }
}
