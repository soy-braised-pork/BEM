package com.example.demo.service.impl;

import com.example.demo.dao.mapper.TaskMapper;
import com.example.demo.entity.BemMenuDo;
import com.example.demo.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author zhaohan
 **/
@Slf4j
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    private static KafkaProducer<String,Object> producer = null;
    private static final String URL = "127.0.0.1:18082";
    private static final String TOPIC = "topic-1";

    static {
        HashMap<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, URL);
        config.put(ProducerConfig.ACKS_CONFIG, "all");
        config.put(ProducerConfig.TRANSACTION_TIMEOUT_CONFIG, 5000);
        config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 1024 * 1024 * 30);
        config.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, 1024 * 1024 * 10);
        config.put(ProducerConfig.RETRIES_CONFIG, 0);
        config.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        producer = new KafkaProducer<String, Object>(config);
    }

    @Override
    public void sendMessage() {
        List<BemMenuDo> bemMenu = taskMapper.getBemMenu();
        ProducerRecord<String , Object> record = null;
        for (BemMenuDo bemMenuDo : bemMenu) {
            record = new ProducerRecord<String, Object>(TOPIC, bemMenuDo);
            //发送消息
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (null != e){
                        log.info("send error" + e.getMessage());
                    }else {
                        System.out.println(String.format("offset:%s,partition:%s",recordMetadata.offset(),recordMetadata.partition()));
                    }
                }
            });
        }
        producer.close();
        taskMapper.updateBemMenu();
    }

}

