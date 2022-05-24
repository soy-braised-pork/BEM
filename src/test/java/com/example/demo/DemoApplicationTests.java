package com.example.demo;

import com.example.demo.dao.OperatorDao;
import com.example.demo.dao.PersonDao;
import com.example.demo.dao.mapper.OperatorMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private OperatorMapper operatorMapper;

    @Test
    void contextLoads(){
//        OperatorDao users =  operatorMapper.findByPersonId("111");
//        System.out.println(users);
    }

}
