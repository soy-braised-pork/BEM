package com.buildepidemicmonitoring.demo.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerTest implements Runnable {

    //实例化出producer
    private final KafkaProducer<String,String> producer;
    private final String topic;

    public ProducerTest(String topicName) {
        //创建生产者
        Properties props = new Properties();
        //指定broker
        props.put("bootstrap.servers", "master:9092,slave1:9092,slave2:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        this.producer = new KafkaProducer<String, String>(props);
        this.topic = topicName;
    }



    @Override
    public void run(){
        int messageNo=1;
        try {
            for (;;){
                String messageStr="你好，这是第"+messageNo+"条数据";
                producer.send(new ProducerRecord<String,String>(topic,"Message",messageStr));
                //生产了100条就打印
                if (messageNo%100==0){
                    System.out.println("发送的信息:"+messageStr);
                }
                //生产10000条就退出
                if (messageNo%1000==0){
                    System.out.println("成功发送了"+messageNo+"条");
                    break;
                }
                messageNo++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            producer.close();
        }
    }

    public static void main(String[] args) {
        ProducerTest test=new ProducerTest("KAFKA_TEST");
        Thread thread=new Thread(test);
        thread.start();
    }
}
