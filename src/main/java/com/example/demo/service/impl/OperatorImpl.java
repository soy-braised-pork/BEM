package com.example.demo.service.impl;

import com.example.demo.dao.OperatorDao;
import com.example.demo.dao.mapper.OperatorMapper;
import com.example.demo.dao.PersonDao;
import com.example.demo.entity.OperatorDO;
import com.example.demo.entity.OperatorRequest;
import com.example.demo.service.IOperatorSV;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zlx
 * Creat on 2022-02-14
 */
@Slf4j
@Service
public class OperatorImpl implements IOperatorSV {

    @Autowired
    private OperatorMapper operatorMapper;

    @Override
    public Map checkLogin(OperatorRequest request) throws Exception {
        HashMap map = new HashMap<>();
        if (request==null || StringUtils.isBlank(request.getUserName())
                || StringUtils.isBlank(request.getPassword())){
            map.put("errorCode ", "入参不能为空");
            map.put("success","false");
            map.put("body", null);
            return map;
        }
        OperatorDO operatorDO = operatorMapper.findByPersonId(request.getUserName());
        if (operatorDO==null){
            map.put("errorCode","用户名不存在");
            map.put("success","false");
            map.put("body", null);
            return map;
        }
        if (operatorDO.getOPassword().equals(request.getPassword())){
            map.put("errorCode",null);
            map.put("success","true");
            map.put("body", "成功");
            return map;
        }else {
            map.put("errorCode","密码不正确");
            map.put("success","false");
            map.put("body", null);
            return map;
        }
    }

    @Override
    public List<PersonDao> getOperator() {
        return null;
    }


}
