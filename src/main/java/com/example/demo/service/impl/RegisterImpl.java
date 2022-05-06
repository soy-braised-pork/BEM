package com.example.demo.service.impl;

import com.example.demo.dao.mapper.RegisterMapper;
import com.example.demo.entity.RegisterRequest;
import com.example.demo.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaohan
 **/
@Slf4j
@Service
public class RegisterImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public Map registerOperator(RegisterRequest request) {
        Map map = new HashMap<>();
        if (request == null){
            map.put("error","缺少参数");
            return map;
        }
        if (request.getPassword()==request.getRePassword()){
            registerMapper.insertOperator(request.getUserName(), request.getPassword(), request.getRole(),new Date());
            map.put("success","成功");
            return map;
        }else {
            map.put("error","两次密码不一致");
            return map;
        }
    }

}

