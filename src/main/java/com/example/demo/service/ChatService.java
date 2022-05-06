package com.example.demo.service;

import com.example.demo.entity.BemPageRequest;
import com.example.demo.entity.ChatInsertRequest;

import java.util.Map;

/**
 * @author zhaohan
 **/
public interface ChatService {

    /**
     * 用户新增留言
     * @param request
     * @return
     */
    Map insertChat(ChatInsertRequest request);

    /**
     * 分页查询留言板
     * @param request
     * @return
     */
    Map chatPage(BemPageRequest request);

}

