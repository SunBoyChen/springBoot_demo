package com.zhihua.demo_amqp.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.core.Queue;


@Configuration
public class AmqpConfiguration {

    @Bean
    public Queue queue() {
        return new Queue("roncoo.queue");
    }


}
