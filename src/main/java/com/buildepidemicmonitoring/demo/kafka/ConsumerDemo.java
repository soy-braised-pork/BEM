package com.buildepidemicmonitoring.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class ConsumerDemo {
    //消费监听
    @KafkaListener(topics = {"test.topic"})
    public void onMessage1(ConsumerRecord<?,?> record){
        //消费的哪个topic、partition的消息，打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
    }
}
