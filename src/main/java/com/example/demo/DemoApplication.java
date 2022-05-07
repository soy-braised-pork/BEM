package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import java.util.Properties;

@SpringBootApplication(exclude={HibernateJpaAutoConfiguration.class})
@MapperScan("com.example.demo.dao.mapper")
public class DemoApplication {

//    private static final String TOPIC = "milo2";
//    private static final String BROKER_LIST = "118.212.149.51:9092";
//    private static KafkaConsumer<String,String> consumer = null;
//
//    static {
//        Properties configs = initConfig();
//        consumer = new KafkaConsumer<String, String>(configs);
//    }
//
//    private static Properties initConfig() {
//        Properties properties = new Properties();
//        properties.put("bootstrap.servers", BROKER_LIST);
//        properties.put("group.id", "0");
//        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        properties.setProperty("enable.auto.commit", "true");
//        properties.setProperty("auto.offset.reset", "earliest");
//        return properties;
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//        while (true){
//            ConsumerRecords<String, String> records = consumer.poll(10);
//            for (ConsumerRecord<String, String> record : records){
//                System.out.println(record);
//            }
//        }
    }

}

