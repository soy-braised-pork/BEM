package com.example.demo.service.impl;

import com.example.demo.dao.mapper.LoginMapper;
import com.example.demo.entity.OperatorDO;
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
            map.put("errorCode ", "入参不能为空");
            map.put("success","false");
            map.put("body", null);
            return map;
        }
        OperatorDO operatorDO = loginMapper.selectOperator(request.getUserName());
        if (operatorDO == null){
            map.put("errorCode","未找到指定用户");
            map.put("success","false");
            map.put("body", null);
            return map;
        }
        if (operatorDO.getOPassword().equals(request.getPassword())) {
            loginMapper.updatePassword(request.getUserName(), request.getRePassword());
            map.put("errorCode", null);
            map.put("success","true");
            map.put("body", "成功");
            return map;
        }else {
            map.put("errorCode", "密码不正确");
            map.put("success","false");
            map.put("body", null);
            return map;
        }
    }

}

