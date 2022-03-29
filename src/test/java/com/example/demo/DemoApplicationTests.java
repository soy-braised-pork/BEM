package com.example.demo;

import com.example.demo.dao.mapper.OperatorMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private OperatorMapper operatorMapper;

    @Test
    void contextLoads(){
        List users = operatorMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
