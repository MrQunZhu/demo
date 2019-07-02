package com.example.demo.controller;

import com.example.demo.util.MsgWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: lixq
 * date: 2019/2/27
 * 描述:
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private MsgWriter msgWriter;

    @RequestMapping("/sendMqtt")
    public String sendMqtt(String  sendData){
        msgWriter.sendToMqtt(sendData,"hello");
        return "OK";
    }
}
