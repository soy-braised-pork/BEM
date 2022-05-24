package com.example.demo.dao.mapper;

import com.example.demo.dao.OperatorDao;
import com.example.demo.dao.PersonDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OperatorMapperTest {

    @Autowired
    private OperatorMapper OperatorMapper;

    @Test
    void findByPersonId() {
//        OperatorDao users =  OperatorMapper.findByPersonId("111");
//        System.out.println(users);
    }
}