package com.buildepidemicmonitoring.demo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class DemoController {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @RequestMapping("")
    public String demo(@RequestParam("message") String message){
        kafkaTemplate.send("test.topic",message).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println("发送失败");
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                System.out.println("发送成功");
            }
        });
        return message;
    }
}
