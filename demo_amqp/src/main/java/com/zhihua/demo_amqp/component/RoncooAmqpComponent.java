package com.zhihua.demo_amqp.component;

import com.zhihua.demo_amqp.entity.User;
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
        this.amqpTemplate.convertAndSend("test.queue", msg);
    }

    /**
     * 监听消息
     * @param text
     */
    @RabbitListener(queues = "test.queue")
    public void receiveQueue(String text) {
        System.out.println("接受到：" + text);
    }

    /**
     * 监听消息
     * @param text
     */
    @RabbitListener(queues = "test.queue")
    public void receiveQueue2(String text) {
        System.out.println("接受到2：" + text);
    }


    /**
     * 发送消息 user
     * @param
     */
    public void sendUser() {
        User user=new User();
        user.setName("hzb");
        user.setPass("123456789");
        this.amqpTemplate.convertAndSend("user.queue", user);
    }

    /**
     * 监听消息
     * @param
     */
    @RabbitListener(queues = "user.queue")
    public void receiveQueue2(User user) {
        System.out.println("接受到user：" + user.getName()+"   "+user.getPass());
    }


    //topic ExChange示例
    public void send() {
        String msg1 = "I am topic.mesaage msg======";
        System.out.println("sender1 : " + msg1);
        this.amqpTemplate.convertAndSend("exchange", "topic.message", msg1);

        String msg2 = "I am topic.mesaages msg########";
        System.out.println("sender2 : " + msg2);
        this.amqpTemplate.convertAndSend("exchange", "topic.messages", msg2);
    }


    @RabbitListener(queues = "topic.message")
    public void topicMessageReceiver(String msg) {
        System.out.println("topicMessageReceiver  : " +msg);
    }


    @RabbitListener(queues = "topic.messages")
    public void topicMessagesReceiver(String msg) {
        System.out.println("topicMessageReceiver  : " +msg);
    }


    //fanout ExChange示例


    public void sendFanout() {
        String msgString="fanoutSender :hello i am hzb";
        System.out.println(msgString);
        this.amqpTemplate.convertAndSend("fanoutExchange","abcd.ee", msgString);
    }

    @RabbitListener(queues = "fanout.A")
    public void FanoutReceiverA(String msg) {
        System.out.println("FanoutReceiverA  : " + msg);
    }

    @RabbitListener(queues = "fanout.B")
    public void FanoutReceiverB(String msg) {
        System.out.println("FanoutReceiverB  : " + msg);
    }

    @RabbitListener(queues = "fanout.C")
    public void FanoutReceiverC(String msg) {
        System.out.println("FanoutReceiverC  : " + msg);
    }

}
