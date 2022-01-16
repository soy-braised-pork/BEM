package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zlx
 * Creat on 2022-01-16
 */



@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTests {

    private final Logger logger= LoggerFactory.getLogger(LoggerTests.class);

    @Test
    public void test1(){
        String name="abc";
        String passwd="12345";
        logger.debug("----------------------debug--------------------------");
        logger.info("---------info----------    name:{} passwd:{}",name,passwd);
        logger.error("----------------------error---------------------");
    }
}
