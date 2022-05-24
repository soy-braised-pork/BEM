package com.example.demo.service.impl;

import com.example.demo.dao.mapper.ChatMapper;
import com.example.demo.entity.BemPageRequest;
import com.example.demo.entity.ChatDo;
import com.example.demo.entity.ChatInsertRequest;
import com.example.demo.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaohan
 **/
@Slf4j
@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Override
    public Map insertChat(ChatInsertRequest request) {
        HashMap map = new HashMap<>();
        if (request == null || StringUtils.isEmpty(request.getUserName())
                || StringUtils.isEmpty(request.getContext())){
            map.put("errorCode ", "入参不能为空");
            return map;
        }
        Long chat = chatMapper.insertChat(request.getUserName(), request.getContext(), new Date());
        if (chat < 0L){
            map.put("errorCode ", "入参不能为空");
            return map;
        }
        map.put("errorCode", "success");
        map.put("body", "录入成功");
        return map;
    }

    @Override
    public Map chatPage(BemPageRequest request) {
        HashMap map = new HashMap<>();
        if (request == null){
            map.put("errorCode ", "入参不能为空");
            return map;
        }
        int currPage;
        currPage= request.getCurrPage()* request.getLimit();
        List<ChatDo> dos = chatMapper.chatPage(currPage, request.getLimit());
        map.put("errorCode", "success");
        map.put("body", dos);
        return map;
    }

}

