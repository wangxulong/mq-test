package com.wang.mq.mqtest;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HelloSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    ConfirmCallBackListener confirmCallBackListener;
    @Autowired
    private ReturnCallBackListener returnCallBackListener;
    public void send(){
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        rabbitTemplate.setConfirmCallback(confirmCallBackListener);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback(returnCallBackListener);

        //confirm--:correlationData:null,ack:true,cause:null
        this.rabbitTemplate.convertAndSend("hello", context);
    }
}
