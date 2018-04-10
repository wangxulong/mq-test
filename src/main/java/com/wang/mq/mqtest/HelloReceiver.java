package com.wang.mq.mqtest;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class HelloReceiver {

    @RabbitListener(queues = "hello")
    public void process(String msg) {
        System.out.println("receive:" + msg);

    }
}
