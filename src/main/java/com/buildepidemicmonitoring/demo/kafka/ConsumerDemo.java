package com.buildepidemicmonitoring.demo.kafka;

import com.buildepidemicmonitoring.demo.flume.MyRpcClinetFacade;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class ConsumerDemo {
    //消费监听
    @KafkaListener(topics = {"test.topic"})
    public void onMessage1(ConsumerRecord<?,?> record){
        //消费的哪个topic、partition的消息，打印出消息内容
        MyRpcClinetFacade clinetFacade = new MyRpcClinetFacade("127.0.0.1", 4141);
        clinetFacade.sendDataToFlume(record.topic()+"_"+record.partition()+"_"+record.value());
    }
}
