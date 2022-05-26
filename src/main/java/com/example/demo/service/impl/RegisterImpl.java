package com.example.demo.service.impl;

import com.example.demo.dao.mapper.RegisterMapper;
import com.example.demo.entity.OperatorDO;
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
            map.put("errorCode","缺少参数");
            map.put("success", "false");
            map.put("body", null);
            return map;
        }
        OperatorDO operatorDO = registerMapper.selectOperator(request.getUserName());
        if (operatorDO != null){
            map.put("errorCode","用户已经注册");
            map.put("success", "false");
            map.put("body", null);
            return map;
        }
        if (request.getPassword().equals(request.getRePassword())){
            registerMapper.insertOperator(request.getUserName(), request.getPassword(), request.getRole(),new Date());
            map.put("errorCode", null);
            map.put("success","true");
            map.put("body", "成功");
            return map;
        }else {
            map.put("errorCode","两次密码不一致");
            map.put("success", "false");
            map.put("body", null);
            return map;
        }
    }

}

