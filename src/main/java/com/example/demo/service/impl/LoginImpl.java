package com.example.demo.service.impl;

import com.example.demo.dao.mapper.LoginMapper;
import com.example.demo.entity.RegisterRequest;
import com.example.demo.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaohan
 **/
@Slf4j
@Service
public class LoginImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Map updatePassword(RegisterRequest request) {
        Map map = new HashMap<>();
        if (request == null){
            map.put("errorCode","缺少参数");
            return map;
        }
        loginMapper.updatePassword(request.getUserName(), request.getRePassword());
        map.put("errorCode","成功");
        return map;
    }

}

