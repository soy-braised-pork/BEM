package com.example.demo.controller;

import com.example.demo.entity.BemPageRequest;
import com.example.demo.entity.ChatInsertRequest;
import com.example.demo.service.impl.ChatServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author zhaohan
 **/
@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatServiceImpl chatService;

    @PostMapping("/insert")
    public Map insertChat(HttpServletRequest servletRequest, @RequestBody ChatInsertRequest request){
        Map map = chatService.insertChat(request);
        return map;
    }

    @PostMapping("/page")
    public Map chatPage(HttpServletRequest servletRequest, @RequestBody BemPageRequest request){
        Map map = chatService.chatPage(request);
        return map;
    }

}


