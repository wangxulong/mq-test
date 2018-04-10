package com.wang.mq.mqtest;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReturnCallBackListener implements RabbitTemplate.ReturnCallback {

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("text: " + replyText + " code: " + replyCode + " exchange: " + exchange + " routingKey :" + routingKey);
    }
}
