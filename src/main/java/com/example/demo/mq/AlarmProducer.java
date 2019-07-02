package com.example.demo.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author: lixq
 * @date: 2019-05-29
 * @描述: 报警消息Producer
 */
@Component
public class AlarmProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination, String message){
        this.jmsTemplate.convertAndSend(destination, message);
    }
}
