package com.buildepidemicmonitoring.demo.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class ConsumerTest implements Runnable {

    private final KafkaConsumer<String, String> consumer;
    private ConsumerRecords<String, String> msgList;
    private final String topic;
    private static final String GROUPID = "groupA";

    public ConsumerTest(String topicName) {
        Properties props = new Properties();
        //bootstrap kafka地址
        props.put("bootstrap.server", "master:9092,slave1:9092,slave2:9092");
        //组名
        props.put("group.id", GROUPID);
        //是否自动提交
        props.put("enable.auto.commit", true);
        //从poll（拉）的回话处理时长
        props.put("auto.commit.interval.ms", "30000");
        //消费规则，默认 earliest
        /*
        earliest：当各分区下有已提交的offset时，从提交的offset开始消费；
                  无提交的offset时，从头开始消费。
        latest：当各分区下有已提交的offset时，从提交的offset开始消费；
                无提交的offset时，消费新产生的该分区下的数据。
        none：topic各分区都存在已提交的offset时，从offset后开始消费；
              只要有一个分区不存在已提交的offset，则抛出异常。
         */
        props.put("auto.offset.reset", "earliest");
        //键序列化
        props.put("key.deserializer", StringDeserializer.class.getName());
        //值序列化
        props.put("value.deserializer", StringDeserializer.class.getName());
        this.consumer = new KafkaConsumer<String, String>(props);
        this.topic = topicName;
        this.consumer.subscribe(Arrays.asList(topic));
    }

    @Override
    public void run() {
        int messageNo = 1;
        System.out.println("------开始消费-----");
        try {
            for (; ; ) {
                msgList = consumer.poll(1000);
                if (null != msgList && msgList.count() > 0) {
                    for (ConsumerRecord<String, String> record : msgList) {
                        //消费100条就打印，但打印的数据不一定是这个规律的
                        if (messageNo % 100 == 0) {
                            System.out.println(messageNo + "======recode======");
                        }
                        //当消费了1000条就退出
                        if (messageNo % 1000 == 0) {
                            break;
                        }
                        messageNo++;
                    }
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }

    public static void main(String[] args) {
        ConsumerTest test1 = new ConsumerTest("KAFKA_TEST");
        Thread thread1 = new Thread(test1);
        thread1.start();
    }


}
