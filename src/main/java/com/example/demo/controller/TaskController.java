package com.example.demo.controller;

import com.example.demo.service.TaskService;
import com.example.demo.service.impl.TaskServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

/**
 * @author zhaohan
 * 定时任务controller
 **/
@Slf4j
@Controller
@EnableScheduling
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     * 每天3点发送机器的数据信息
     * @return
     */
    @Scheduled(cron = "0 0 3 * * *")
    public void sendMessage(){
        taskService.sendMessage();
    }

}

